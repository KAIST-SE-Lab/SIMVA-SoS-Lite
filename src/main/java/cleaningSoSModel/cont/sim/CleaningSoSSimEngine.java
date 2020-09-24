package cleaningSoSModel.cont.sim;

import cleaningSoSModel.model.behv.Moving;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.strc.CleaningSoS;
import cleaningSoSModel.model.strc.Robot;
import cleaningSoSModel.simdata.input.CleaningSoSConfiguration;
import cleaningSoSModel.simdata.input.CleaningSoSScenario;
import kr.ac.kaist.se.cont.sim.SimEngine;
import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.simdata.input.SimScenarioEvent;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;
import kr.ac.kaist.se.simdata.output.record.SimLog;

import java.util.ArrayList;

public class CleaningSoSSimEngine extends SimEngine {
    public CleaningSoSSimEngine(CleaningSoS cleaningSoS, CleaningSoSConfiguration cleaningSoSConfiguration, CleaningSoSScenario cleaningSoSScenario) {
        super(cleaningSoS, cleaningSoSConfiguration, cleaningSoSScenario);
    }

    public SimLog executeSimulation() {
        SimLog simLog = new SimLog();

        sos.updateMapObjectLocationArrayListHashMap();
        for(int i = 0; i < this.simConfiguration.totalTimeFrame; i++) {
            UpdateResult updateResult = new UpdateResult("Tick " + i);
            ArrayList<SimScenarioEvent> eventList = this.getEvent();
            if(eventList.size() > 0){
                executeEvent(eventList);
            }

            RunResult simulationResult = runSimulation();
            simulationResult = this.resolveConflict(simulationResult);
            UpdateResult updateResult1 = this.updateSimulation(simulationResult);
            updateResult.addAllLog(updateResult1.getLog());
            simLog.addUpdateResult(updateResult);

            sos.updateMapObjectLocationArrayListHashMap();
        }
        return simLog;
    }

    protected RunResult resolveConflict(RunResult simulationResult) {
        ArrayList<RunResult> checkList = new ArrayList<RunResult>(0);
        checkList.add(simulationResult);

        ArrayList<CleaningSoSObjectLocation> occupiedLocation = new ArrayList<CleaningSoSObjectLocation>(0);

        while(checkList.size() != 0) {
            boolean needsRemove = false;
            RunResult targetRunResult = checkList.get(0);
            checkList.remove(targetRunResult);

            _SimObject_ target = targetRunResult.getTarget();
            if(target instanceof Robot){
                CleaningSoSObjectLocation movedLocation = null;
                CleaningSoSObjectLocation targetLocation = (CleaningSoSObjectLocation) target.getLocation();

                ArrayList<_SimAction_> targetActionList = targetRunResult.getSelectedActionList();
                for(_SimAction_ targetAction: targetActionList){
                    if(targetAction instanceof Moving){
                        Moving movingTargetAction = (Moving) targetAction;
                        movedLocation = new CleaningSoSObjectLocation(targetLocation.getX() + movingTargetAction.getXDiff(), targetLocation.getY() + movingTargetAction.getYDiff(), targetLocation.getFloor());
                    }
                }

                for(CleaningSoSObjectLocation cleaningSoSObjectLocation: occupiedLocation){
                    if((movedLocation != null && cleaningSoSObjectLocation.isSameLocation(movedLocation)) || (movedLocation == null && cleaningSoSObjectLocation.isSameLocation(targetLocation))){
                        // 지워버린다.
                        needsRemove = true;
                    }
                }

                if (movedLocation == null){
                    occupiedLocation.add(targetLocation);
                }
                if (movedLocation != null && needsRemove){
                    occupiedLocation.add(targetLocation);
                }
                if (movedLocation != null && !needsRemove){
                    occupiedLocation.add(movedLocation);
                }
            }

            checkList.addAll(targetRunResult.getChildRunResults());

            if (needsRemove){
                targetRunResult.clearSelectedActionList();
            }
        }
        return simulationResult;
    }
}

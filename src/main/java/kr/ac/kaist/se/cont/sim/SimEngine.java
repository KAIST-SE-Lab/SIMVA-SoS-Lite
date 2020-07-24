package kr.ac.kaist.se.cont.sim;

import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.input.*;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;
import kr.ac.kaist.se.simdata.output.record.SimLog;

import java.util.ArrayList;

public class SimEngine {
    SoS soS;
    SimConfiguration simConfiguration;
    SimScenario simScenario;
    ArrayList<SimScenarioEvent> simScenarioEvents;

    public SimEngine(SoS simpleSoS, SimConfiguration simConfiguration, SimScenario simScenario) {
        this.soS = simpleSoS;
        this.simConfiguration = simConfiguration;
        this.simScenario = simScenario;
        this.simScenarioEvents = generateEvents(simScenario);
    }
    
    private ArrayList<SimScenarioEvent> generateEvents(SimScenario simScenario) {
        return new ArrayList<SimScenarioEvent>(0);
    }

    public SimLog executeSimulation() {
        for(int i = 0; i < this.simConfiguration.totalTimeFrame; i++) {
            System.out.println("Tick " + i);
            ArrayList<SimScenarioEvent> eventList = this.getEvent();
            if(eventList.size() > 0){
                executeEvent(eventList);
            }

            RunResult simulationResult = this.runSimulation();
            simulationResult = this.resolveConflict(simulationResult);
            UpdateResult updateResult = this.updateSimulation(simulationResult);
        }
        return null;
    }

    private ArrayList<SimScenarioEvent> getEvent() {
        for(SimScenarioEvent simScenarioEvent: simScenarioEvents) {

        }
        return new ArrayList<SimScenarioEvent>(0);
    }

    private void executeEvent(ArrayList<SimScenarioEvent> eventList) {
    }

    private RunResult runSimulation() {
        return soS.run();
    }

    private RunResult resolveConflict(RunResult simulationResult) {
        return null;
    }

    private UpdateResult updateSimulation(RunResult runResult) {
        soS.update(runResult);
        return null;
    }
}

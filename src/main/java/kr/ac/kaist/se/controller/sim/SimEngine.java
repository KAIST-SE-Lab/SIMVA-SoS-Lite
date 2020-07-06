package kr.ac.kaist.se.controller.sim;

import kr.ac.kaist.se.model.sos.SoS;
import kr.ac.kaist.se.simdata.input.*;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;
import kr.ac.kaist.se.simdata.output.record.SimLog;

import java.util.ArrayList;

public class SimEngine {
    SoS simpleSoS;
    SimConfiguration simConfiguration;
    SimScenario simScenario;
    ArrayList<SimScenarioEvent> simScenarioEvents;

    public SimEngine(SoS simpleSoS, SimConfiguration simConfiguration, SimScenario simScenario) {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine()");
        this.simpleSoS = simpleSoS;
        this.simConfiguration = simConfiguration;
        this.simScenario = simScenario;
        this.simScenarioEvents = generateEvents(simScenario);
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine()");
    }
    
    private ArrayList<SimScenarioEvent> generateEvents(SimScenario simScenario) {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.generateEvents()");
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.generateEvents()");
        return new ArrayList<SimScenarioEvent>(0);
    }

    public SimLog executeSimulation() {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.executeSimulation()");
        for(int i = 0; i < this.simConfiguration.totalTimeFrame; i++) {
            System.out.println("Tick " + i);
            ArrayList<SimScenarioEvent> eventList = this.getEvent();
            if(eventList.size() > 0){
                executeEvent(eventList);
            }

            RunResult simulationResult = this.runSimulation();
            simulationResult = this.resolveConflict(simulationResult);
            UpdateResult updateResult = this.updateSimulation();
        }
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.executeSimulation()");
        return null;
    }

    private ArrayList<SimScenarioEvent> getEvent() {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.getEvent()");
        for(SimScenarioEvent simScenarioEvent: simScenarioEvents) {}
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.getEvent()");
        return new ArrayList<SimScenarioEvent>(0);
    }

    private void executeEvent(ArrayList<SimScenarioEvent> eventList) {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.executeEvent()");
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.executeEvent()");
    }

    private RunResult runSimulation() {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.runSimulation()");

        simpleSoS.run();

        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.runSimulation()");
        return null;
    }

    private RunResult resolveConflict(RunResult simulationResult) {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.resolveConflict()");
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.resolveConflict()");
        return null;
    }

    private UpdateResult updateSimulation() {
        System.out.println("Start kr.ac.kaist.se.controller.sim.SimEngine.updateSimulation()");
        System.out.println("End kr.ac.kaist.se.controller.sim.SimEngine.updateSimulation()");
        return null;
    }
}

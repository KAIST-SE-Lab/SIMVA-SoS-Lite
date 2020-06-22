package kr.ac.kaist.se.controller.sim;

import kr.ac.kaist.se.simdata.input.*;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;
import kr.ac.kaist.se.simdata.output.record.SimLog;

import java.util.ArrayList;

public class SimEngine {
    SimConfiguration simConfiguration;
    SimScenario simScenario;
    ArrayList<SimScenarioEvent> simScenarioEvents;

    public SimEngine(String configurationFile, String scenarioFile) {
        this.readConfiguration(configurationFile);
        this.readScenario(scenarioFile);
    }

    private void readConfiguration(String fileName) {
        this.simConfiguration = new SimpleConfiguration();
    }

    private void readScenario(String fileName) {
        this.simScenario = new SimpleScenario();
        this.simScenarioEvents = new ArrayList<>();
    }

    public SimLog executeSimulation() {
        for(int i = 0; i < this.simConfiguration.totalTimeFrame; i++) {
            ArrayList<SimScenarioEvent> eventList = this.getEvent();
            if(eventList.size() > 0){
                executeEvent(eventList);
            }

            RunResult simulationResult = this.runSimulation();
            simulationResult = this.resolveConflict(simulationResult);
            UpdateResult updateResult = this.updateSimulation();
        }
        return null;
    }

    private ArrayList<SimScenarioEvent> getEvent() {
        return null;
    }

    private void executeEvent(ArrayList<SimScenarioEvent> eventList) {

    }

    private RunResult runSimulation() {
        return null;
    }

    private RunResult resolveConflict(RunResult simulationResult) {
        return null;
    }

    private UpdateResult updateSimulation() {
        return null;
    }
}

package cleaningSoSModel;

import cleaningSoSModel.model.strc.CleaningOrganization;
import kr.ac.kaist.se.cont.sim.SimEngine;
import cleaningSoSModel.model.strc.SweepingRobot;
import cleaningSoSModel.model.strc.CleaningSoS;
import cleaningSoSModel.simdata.input.CleaningSoSConfiguration;
import cleaningSoSModel.simdata.input.CleaningSoSScenario;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;
import kr.ac.kaist.se.simdata.output.record.SimLog;

public class main {
    public static void main(String [] args) {
        String modelFile = "";
        CleaningSoS cleaningSoS = readModel(modelFile);

        String configurationFile = "";
        CleaningSoSConfiguration cleaningSoSConfiguration = readConfiguration(configurationFile);

        String scenarioFile = "";
        CleaningSoSScenario cleaningSoSScenario = readScenario(scenarioFile);

        SimEngine simEngine = new SimEngine(cleaningSoS, cleaningSoSConfiguration, cleaningSoSScenario);
        SimLog simLog = simEngine.executeSimulation();

        for(UpdateResult updateResult: simLog.getUpdateResult()) {
            for(String string: updateResult.getLog()) {
                System.out.println(string);
            }
            System.out.println("");
        }
    }

    private static CleaningSoS readModel(String fileName) {
        CleaningSoS cleaningSoS = new CleaningSoS("cleaningSoS");
        CleaningOrganization cleaningOrganization = new CleaningOrganization("cleaningOrganization", cleaningSoS);

        SweepingRobot sweepingRobot1 = new SweepingRobot(cleaningSoS, cleaningOrganization, 0, 0, "sweepingRobot1");
        SweepingRobot sweepingRobot2 = new SweepingRobot(cleaningSoS, cleaningOrganization, 0, 0, "sweepingRobot2");
        return cleaningSoS;
    }

    private static CleaningSoSConfiguration readConfiguration(String fileName) {
        CleaningSoSConfiguration cleaningSoSConfiguration = new CleaningSoSConfiguration(10);
        return cleaningSoSConfiguration;
    }

    private static CleaningSoSScenario readScenario(String fileName) {
        return new CleaningSoSScenario();
    }
}

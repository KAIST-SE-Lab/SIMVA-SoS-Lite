package cleaningSoSModel;

import cleaningSoSModel.cont.sim.CleaningSoSSimEngine;
import cleaningSoSModel.model.geo.Floor;
import cleaningSoSModel.model.strc.*;
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

        CleaningSoSSimEngine cleaningSoSSimEngine = new CleaningSoSSimEngine(cleaningSoS, cleaningSoSConfiguration, cleaningSoSScenario);
        SimLog simLog = cleaningSoSSimEngine.executeSimulation();

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

        SweepingRobot sweepingRobot1 = new SweepingRobot(cleaningSoS, cleaningOrganization, 0, 0, Floor.FIRST, "sweepingRobot1");
        SweepingRobot sweepingRobot2 = new SweepingRobot(cleaningSoS, cleaningOrganization, 0, 1, Floor.FIRST, "sweepingRobot2");

        CleaningEnvironment cleaningEnvironment = new CleaningEnvironment("cleaningEnvironment", cleaningSoS);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                String name = "tile" + Integer.toString(i) + Integer.toString(j);
                if (i != 1 || j != 1){
                    Tile tile = new Tile(name + "FIRST", i, j, Floor.FIRST, cleaningEnvironment);
                }
                Tile tileUnder = new Tile(name + "UNDERGROUND", i, j, Floor.UNDERGROUND, cleaningEnvironment);
            }
        }

        OutdoorDust outdoorDust = new OutdoorDust("outdoorDust", cleaningEnvironment);
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

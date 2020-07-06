package simpleModel;

import kr.ac.kaist.se.controller.sim.SimEngine;
import kr.ac.kaist.se.model.sos.SoS;
import simpleModel.model.sos.SimpleCS;
import simpleModel.model.sos.SimpleSoS;
import simpleModel.simdata.input.SimpleConfiguration;
import simpleModel.simdata.input.SimpleScenario;
import sprt.SPRTVerificationEngine;
import simpleModel.model.property.SimpleProperty;
import simpleModel.model.property.SimplePropertyChecker;

import java.util.ArrayList;

public class main {
    public static void main(String [] args) {
        String modelFile = "";
        SimpleSoS simpleSoS = readModel(modelFile);

        String configurationFile = "";
        SimpleConfiguration simpleConfiguration = readConfiguration(configurationFile);

        String scenarioFile = "";
        SimpleScenario simpleScenario = readScenario(scenarioFile);

        SimEngine simEngine = new SimEngine(simpleSoS, simpleConfiguration, simpleScenario);
        simEngine.executeSimulation();

//        SimpleProperty property = new SimpleProperty("Simple", "Nothing", "Nothing");
//        SimplePropertyChecker propertyChecker = new SimplePropertyChecker();
//
//        SPRTVerificationEngine sprtVerificationEngine = new SPRTVerificationEngine(simEngine, property, propertyChecker);
//        sprtVerificationEngine.verifySimulation();
    }

    private static SimpleSoS readModel(String fileName) {
        System.out.println("Start main.readModel()");

        SimpleSoS simpleSoS = new SimpleSoS();
        simpleSoS.sos_csList.add(new SimpleCS());

        System.out.println("End main.readModel()");
        return simpleSoS;
    }

    private static SimpleConfiguration readConfiguration(String fileName) {
        System.out.println("Start main.readConfiguration()");

        SimpleConfiguration simpleConfiguration = new SimpleConfiguration(10);

        System.out.println("End main.readConfiguration()");
        return simpleConfiguration;
    }

    private static SimpleScenario readScenario(String fileName) {
        System.out.println("Start main.readScenario()");
        System.out.println("End main.readScenario()");
        return new SimpleScenario();
    }
}

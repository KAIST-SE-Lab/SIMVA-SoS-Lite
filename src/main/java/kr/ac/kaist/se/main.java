package kr.ac.kaist.se;

import kr.ac.kaist.se.controller.sim.SimEngine;
import kr.ac.kaist.se.controller.verif.SPRTVerificationEngine;
import kr.ac.kaist.se.model.property.SimpleProperty;
import kr.ac.kaist.se.model.property.SimplePropertyChecker;

public class main {
    public static void main(String [] args) {
        String configurationFile = "";
        String scenarioFile = "";

        SimEngine simEngine = new SimEngine(configurationFile, scenarioFile);
        simEngine.executeSimulation();

        SimpleProperty property = new SimpleProperty("Simple", "Nothing", "Nothing");
        SimplePropertyChecker propertyChecker = new SimplePropertyChecker();

        SPRTVerificationEngine sprtVerificationEngine = new SPRTVerificationEngine(simEngine, property, propertyChecker);
        sprtVerificationEngine.verifySimulation();
    }
}

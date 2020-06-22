package kr.ac.kaist.se.controller.verif;

import kr.ac.kaist.se.controller.sim.SimEngine;
import kr.ac.kaist.se.model.property.Property;
import kr.ac.kaist.se.model.property.PropertyChecker;

public abstract class VerificationEngine {
    SimEngine simEngine;
    Property property;
    PropertyChecker propertyChecker;

    public VerificationEngine(SimEngine simEngine, Property property, PropertyChecker propertyChecker) {
        this.simEngine = simEngine;
        this.property = property;
        this.propertyChecker = propertyChecker;
    }

    public abstract void verifySimulation();
}

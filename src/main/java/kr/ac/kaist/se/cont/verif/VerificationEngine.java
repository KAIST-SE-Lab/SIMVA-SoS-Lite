package kr.ac.kaist.se.cont.verif;

import kr.ac.kaist.se.cont.sim.SimEngine;
import kr.ac.kaist.se.model.property.Property;
import kr.ac.kaist.se.model.property.PropertyChecker;

public abstract class VerificationEngine {
    public SimEngine simEngine;
    public Property property;
    public PropertyChecker propertyChecker;

    public VerificationEngine(SimEngine simEngine, Property property, PropertyChecker propertyChecker) {
        this.simEngine = simEngine;
        this.property = property;
        this.propertyChecker = propertyChecker;
    }

    public abstract void verifySimulation();
}

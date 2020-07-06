package simpleModel.model.property;

import kr.ac.kaist.se.model.property.Property;

public class SimpleProperty extends Property {
    public SimpleProperty(String name, String specification, String propertyType) {
        super(name, specification, propertyType);
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public double getThresholdValue() {
        return 0;
    }

    @Override
    public double getProb() {
        return 0;
    }

    @Override
    public int getT() {
        return 0;
    }

    @Override
    public int getTT() {
        return 0;
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public String getPrevState() {
        return null;
    }
}

package kr.ac.kaist.se.model.property;

public abstract class Property {
    String name;
    String specification;
    String type;

    public Property(String name, String specification, String propertyType) {
        this.name = name;
        this.specification = specification;
        this.type = propertyType;
    }

    public abstract double getValue();
    public abstract double getThresholdValue();
    public abstract double getProb();
    public abstract int getT();
    public abstract int getTT();
    public abstract int getDuration();
    public abstract String getState();
    public abstract String getPrevState();
}

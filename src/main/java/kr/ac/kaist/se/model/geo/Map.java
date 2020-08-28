package kr.ac.kaist.se.model.geo;

public abstract class Map {
    public abstract boolean isValidLocation(ObjectLocation loc);
    public abstract LocationInformation getLocationInfo(ObjectLocation loc);
}
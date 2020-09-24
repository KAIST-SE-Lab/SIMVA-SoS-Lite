package kr.ac.kaist.se.model.geo;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

import java.util.ArrayList;

public abstract class LocationInformation {
    protected ArrayList<_SimObject_> objectArrayList;

    public LocationInformation(ArrayList<_SimObject_> objectArrayList) {
        this.objectArrayList = objectArrayList;
    }

    public ArrayList<_SimObject_> getObjectArrayList() {
        return objectArrayList;
    }
}
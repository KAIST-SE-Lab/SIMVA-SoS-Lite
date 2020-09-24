package kr.ac.kaist.se.model.geo;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Map {
    protected HashMap<ObjectLocation, ArrayList<_SimObject_>> objectLocationArrayListHashMap;

    public Map() {
        this.objectLocationArrayListHashMap = new HashMap<ObjectLocation, ArrayList<_SimObject_>>(0);
    }

    public abstract boolean isValidLocation(ObjectLocation loc);
    public abstract LocationInformation getLocationInfo(ObjectLocation loc);

    public ArrayList<_SimObject_> getLocationArrayList(ObjectLocation location){
        for(ObjectLocation key: this.objectLocationArrayListHashMap.keySet()){
            if (key.isSameLocation(location)){
                return this.objectLocationArrayListHashMap.get(key);
            }
        }

        return new ArrayList<_SimObject_>(0);
    }

    public void addObjectLocationArrayListHashMap(ObjectLocation location, _SimObject_ object){
        for(ObjectLocation key: this.objectLocationArrayListHashMap.keySet()){
            if (key.isSameLocation(location)){
                this.objectLocationArrayListHashMap.get(key).add(object);
                return;
            }
        }

        this.objectLocationArrayListHashMap.put(location, new ArrayList<_SimObject_>(0));
        this.objectLocationArrayListHashMap.get(location).add(object);
    }

    public void clearObjectLocationArrayListHashMap(){
        this.objectLocationArrayListHashMap.clear();
    }
}
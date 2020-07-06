package kr.ac.kaist.se.model.abst.sys;

import kr.ac.kaist.se.intf.Simulatable;

abstract public class _SimObject_ implements Simulatable {
    String id;
    String name;
    boolean isAvailable;
    boolean isActivated;

    //TODO: representation of object location
    //curLoc ObjectLocation;
}

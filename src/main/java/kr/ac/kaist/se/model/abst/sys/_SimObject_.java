package kr.ac.kaist.se.model.abst.sys;

import kr.ac.kaist.se.intf.Simulatable;

abstract public class _SimObject_ implements Simulatable {
    protected String id;
    protected String name;
    protected boolean isAvailable;
    protected boolean isActivated;

    //TODO: representation of object location
    //curLoc ObjectLocation;
}

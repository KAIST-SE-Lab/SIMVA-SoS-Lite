package kr.ac.kaist.se.model.abst.sys;

import kr.ac.kaist.se.intf.Simulatable;
import kr.ac.kaist.se.model.geo.ObjectLocation;

abstract public class _SimObject_ implements Simulatable {
    protected String id;
    protected String name;
    protected boolean isAvailable;
    protected boolean isActivated;

    protected ObjectLocation location;

    public String getName() {
        return name;
    }

    public ObjectLocation getLocation(){
        return this.location;
    }
}

package kr.ac.kaist.se.abst;

import kr.ac.kaist.se.intf.Simulatable;
import kr.ac.kaist.se.model.geo.ObjectLocation;

public abstract class SimObject implements Simulatable {
    private String id;
    private String name;
    private boolean isAvailable;
    private boolean isActivated;
    private ObjectLocation curLoc;
}

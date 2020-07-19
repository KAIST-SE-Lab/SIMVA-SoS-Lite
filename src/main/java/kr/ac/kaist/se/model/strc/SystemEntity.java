package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.Communicatable;
import kr.ac.kaist.se.intf.Stateful;
import kr.ac.kaist.se.model.abst.sys._SimActionableObject_;

abstract public class SystemEntity extends _SimActionableObject_
        implements Communicatable, Stateful {

    protected EnumSystemState curState;
}

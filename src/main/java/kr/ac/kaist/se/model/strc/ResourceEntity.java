package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.Possessable;
import kr.ac.kaist.se.intf.Resourcizable;
import kr.ac.kaist.se.model.abst.sys._SimNonActionableObject_;

abstract public class ResourceEntity extends _SimNonActionableObject_ implements Resourcizable, Possessable {

    protected EnumResState resState;
}

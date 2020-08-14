package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

import java.util.ArrayList;

abstract public class Environment extends _SimObject_ {

    protected EnumEnvType envType;

    protected ArrayList<ActiveEnvElement> activeEnvElmtList;
    protected ArrayList<PassiveEnvElement> passiveEnvElmtList;
}

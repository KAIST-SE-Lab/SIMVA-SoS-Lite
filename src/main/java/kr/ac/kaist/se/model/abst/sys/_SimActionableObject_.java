package kr.ac.kaist.se.model.abst.sys;

import kr.ac.kaist.se.intf.Actionable;
import kr.ac.kaist.se.model.abst.cap._SimAction_;

import java.util.ArrayList;

abstract public class _SimActionableObject_ extends _SimObject_ implements Actionable {

    protected ArrayList<_SimAction_> actionList;
    protected ArrayList<_SimAction_> selectedActionList;

    abstract protected void selectActions(); //TODO: set return
}

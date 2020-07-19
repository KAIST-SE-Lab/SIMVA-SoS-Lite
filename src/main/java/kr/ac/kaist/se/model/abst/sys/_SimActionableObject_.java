package kr.ac.kaist.se.model.abst.sys;

import kr.ac.kaist.se.intf.Actionable;
import kr.ac.kaist.se.model.abst.cap._SimAction_;

import java.util.ArrayList;

abstract public class _SimActionableObject_ extends _SimObject_ implements Actionable {

    ArrayList<_SimAction_> actionList;
    ArrayList<_SimAction_> selectedActionList;

    abstract void selectActions(); //TODO: set return
}

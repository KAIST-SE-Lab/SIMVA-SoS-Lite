package kr.ac.kaist.se.model.abst.sys;

import kr.ac.kaist.se.intf.Actionable;
import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.behv.Action;

import java.util.ArrayList;

abstract public class _SimActionableObject_ extends _SimObject_ implements Actionable {

    protected ArrayList<_SimAction_> actionList;
    protected ArrayList<_SimAction_> selectedActionList;

    public ArrayList<_SimAction_> getActionList() {
        return actionList;
    }

    public void addAction(_SimAction_ simAction) {
        this.actionList.add(simAction);
    }

    public void removeAction(_SimAction_ simAction) {
        this.actionList.remove(simAction);
    }

    public ArrayList<_SimAction_> getSelectedActionList() {
        return selectedActionList;
    }

    public void addSelectedAction(_SimAction_ simAction) {
        this.selectedActionList.add(simAction);
    }

    public void removeSelectedAction(_SimAction_ simAction) {
        this.selectedActionList.remove(simAction);
    }

    public void clearSelectedAction() {
        this.selectedActionList.clear();
    }

    abstract protected void selectActions(); //TODO: set return
}

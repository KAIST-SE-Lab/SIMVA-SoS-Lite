package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.Moving;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.CS;

import java.util.ArrayList;

public abstract class Robot extends CS {
    private CleaningSoSObjectLocation location;
    private ArrayList<Action> actionList;
    private ArrayList<Action> selectedActionList;

    public Robot(int x, int y){
        this.location = new CleaningSoSObjectLocation(x, y);
        this.actionList = new ArrayList<Action>(0);
        this.selectedActionList = new ArrayList<Action>(0);

        this.actionList.add(new Moving(this, 0, 0));
    }

    public CleaningSoSObjectLocation getLocation() {
        return this.location;
    }

    public ArrayList<Action> getActionList() {
        return this.actionList;
    }

    public ArrayList<Action> getSelectedActionList() {
        return this.selectedActionList;
    }

    public void addAction(Action action) {
        this.actionList.add(action);
    }

    public void removeAction(Action action) {
        this.actionList.remove(action);
    }

    public void clearAction() {
        this.actionList.clear();
    }

    public void addSelectedAction(Action action) {
        this.selectedActionList.add(action);
    }

    public void removeSelectedAction(Action action) {
        this.selectedActionList.remove(action);
    }

    public void clearSelectedAction() {
        this.selectedActionList.clear();
    }
}

package kr.ac.kaist.se.simdata.output.intermediate;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Action;

import java.util.ArrayList;

public class RunResult {
    private _SimObject_ target;
    private ArrayList<Action> selectedActionList;
    private ArrayList<RunResult> childRunResults;

    public RunResult(_SimObject_ target, ArrayList<Action> selectedActionList) {
        this.target = target;
        this.selectedActionList = selectedActionList;
        this.childRunResults = new ArrayList<RunResult>(0);
    }

    public _SimObject_ getTarget() {
        return target;
    }

    public ArrayList<Action> getSelectedActionList() {
        return selectedActionList;
    }

    public void addChildRunResult(RunResult runResult) {
        this.childRunResults.add(runResult);
    }

    public void removeChildRunResult(RunResult runResult) {
        this.childRunResults.add(runResult);
    }

    public void clearChildRunResult() {
        this.childRunResults.clear();
    }
}

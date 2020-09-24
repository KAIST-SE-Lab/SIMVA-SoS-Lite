package kr.ac.kaist.se.simdata.output.intermediate;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Action;

import java.util.ArrayList;

public class RunResult {
    private _SimObject_ target;
    private ArrayList<_SimAction_> selectedActionList;
    private ArrayList<RunResult> childRunResults;

    public RunResult(_SimObject_ target, ArrayList<_SimAction_> selectedActionList) {
        this.target = target;
        this.selectedActionList = selectedActionList;
        this.childRunResults = new ArrayList<RunResult>(0);
    }

    public _SimObject_ getTarget() {
        return target;
    }

    public ArrayList<_SimAction_> getSelectedActionList() {
        return selectedActionList;
    }

    public ArrayList<RunResult> getChildRunResults() {
        return childRunResults;
    }

    public void addChildRunResult(RunResult runResult) {
        this.childRunResults.add(runResult);
    }

    public void removeChildRunResult(RunResult runResult) {
        this.childRunResults.remove(runResult);
    }

    public void clearChildRunResult() {
        this.childRunResults.clear();
    }

    public void clearSelectedActionList() {
        this.selectedActionList.clear();
    }
}

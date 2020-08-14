package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimActionableObject_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class ActiveEnvElement extends _SimActionableObject_ {

    public void doAction(_SimAction_ simAction) {
        simAction.executeAction();
    }

    protected void selectActions() {

    }

    public RunResult run() {
        this.clearSelectedAction();
        this.selectActions();
        return new RunResult(this, this.selectedActionList);
    }

    public UpdateResult update(RunResult runResult) {
        UpdateResult updateResult = new UpdateResult(this.name);

        for (_SimAction_ selectedAction: runResult.getSelectedActionList()) {
            doAction(selectedAction);
        }
        return updateResult;
    }
}

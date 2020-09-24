package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimActionableObject_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public abstract class ActiveEnvElement extends _SimActionableObject_ {
    protected Environment environment;

    public ActiveEnvElement(String name, Environment environment){
        this.name = name;
        this.environment = environment;
        environment.addActiveEnvElement(this);

        this.actionList = new ArrayList<_SimAction_>(0);
        this.selectedActionList = new ArrayList<_SimAction_>(0);
    }

    public void doAction(_SimAction_ simAction) {
        simAction.executeAction();
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
            updateResult.addLog(selectedAction.getName());
        }
        return updateResult;
    }
}

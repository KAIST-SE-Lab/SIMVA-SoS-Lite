package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimNonActionableObject_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class PassiveEnvElement extends _SimNonActionableObject_ {
    protected Environment environment;

    public PassiveEnvElement(String name, Environment environment){
        this.name = name;
        this.environment = environment;
    }

    public RunResult run() {
        return new RunResult(this, null);
    }

    public UpdateResult update(RunResult runResult) {
        return new UpdateResult(this.name);
    }
}

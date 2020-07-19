package kr.ac.kaist.se.instances;

import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.CS;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public class SimpleSoSModel extends SoS {

    public RunResult run() {
        RunResult runResult = new RunResult(this, new ArrayList<Action>(0));

        for(CS cs: this.csList) {
            runResult.addChildRunResult(cs.run());
        }
        return runResult;
    }

    public UpdateResult update() {
        for(CS cs: this.csList) {
            cs.update();
        }
        return null;
    }
}

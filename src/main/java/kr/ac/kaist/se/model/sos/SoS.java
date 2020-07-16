package kr.ac.kaist.se.model.sos;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

abstract public class SoS extends _SimObject_ {
    public ArrayList<CS> sos_csList;

    public SoS(){
        sos_csList = new ArrayList<CS>(0);
    }

    @Override
    public RunResult run() {
        RunResult runResult = new RunResult(this, new ArrayList<Action>(0));

        for(CS cs: sos_csList) {
            runResult.addChildRunResult(cs.run());
        }
        return runResult;
    }

    @Override
    public UpdateResult update() {
        for(CS cs: sos_csList) {
            cs.update();
        }
        return null;
    }
}

package kr.ac.kaist.se.intf;

import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public interface Simulatable {
    RunResult run();
    UpdateResult update(RunResult runResult);
}

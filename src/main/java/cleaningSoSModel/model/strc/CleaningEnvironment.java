package cleaningSoSModel.model.strc;

import kr.ac.kaist.se.model.strc.*;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class CleaningEnvironment extends Environment {

    public CleaningEnvironment(String name, SoS sos) {
        super(name, sos);
    }

    public RunResult run() {
        return super.run();
    }

    public UpdateResult update(RunResult runResult) {
        return super.update(runResult);
    }
}

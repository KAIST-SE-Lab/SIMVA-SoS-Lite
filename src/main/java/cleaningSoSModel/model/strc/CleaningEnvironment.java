package cleaningSoSModel.model.strc;

import kr.ac.kaist.se.model.strc.*;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class CleaningEnvironment extends Environment {

    public CleaningEnvironment(String name, Environment environment) {
        super(name, environment);
    }

    @Override
    public RunResult run() {
        super.run();
    }

    @Override
    public UpdateResult update(RunResult runResult) {
        super.update(runResult);
    }
}

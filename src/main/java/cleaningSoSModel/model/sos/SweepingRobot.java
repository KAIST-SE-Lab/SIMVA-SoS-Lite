package cleaningSoSModel.model.sos;

import kr.ac.kaist.se.model.sos.CS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public class SweepingRobot extends Robot {

    public SweepingRobot(int x, int y) {
        super(x, y);
        this.addAction(new Sweeping(this));
    }

    @Override
    public void doAction() {
        this.changeState();
    }

    @Override
    public void doDecisionMaking() {
        this.clearSelectedAction();
        if (Math.random() < 0.5) {
            this.addSelectedAction(new Moving(this, 1, 1));
        }
        else {
            this.addSelectedAction(new Sweeping(this));
        }
    }

    @Override
    public RunResult run() {
        doDecisionMaking();
        RunResult runResult = new RunResult(this, this.getSelectedActionList());
        return runResult;
    }

    @Override
    public UpdateResult update() {
        doAction();
        return null;
    }

    @Override
    public void changeState() {

    }
}

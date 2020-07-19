package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.Moving;
import cleaningSoSModel.model.behv.Sweeping;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

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
    public void selectActions(){
        this.doDecisionMaking();
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
        this.selectActions();
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

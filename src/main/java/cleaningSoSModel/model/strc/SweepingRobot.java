package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.Moving;
import cleaningSoSModel.model.behv.Sweeping;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class SweepingRobot extends Robot {

    public SweepingRobot(SoS sos, int x, int y) {
        super(sos, x, y);
        this.addAction(new Sweeping(this));
    }

    @Override
    public void selectActions(){
        if (Math.random() < 0.5) {
            this.addSelectedAction(new Moving(this, 1, 1));
        }
        else {
            this.addSelectedAction(new Sweeping(this));
        }
    }

    @Override
    public void doDecisionMaking() {

    }

    @Override
    public void changeState() {

    }
}

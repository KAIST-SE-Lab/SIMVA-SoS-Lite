package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.*;
import cleaningSoSModel.model.geo.CleaningSoSMap;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.geo.Floor;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.Organization;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;
import java.util.Random;

public class SweepingRobot extends Robot {

    public SweepingRobot(SoS sos, Organization organization, int x, int y, Floor floor, String name) {
        super(sos, organization, x, y, floor);
        this.name = name;
        this.addAction(new Sweeping(this));
    }

    @Override
    public void selectActions(){
        doDecisionMaking();
    }

    public void doDecisionMaking() {
        ArrayList<Action> availableAction = new ArrayList<Action>(0);
        CleaningSoSMap sosMap = (CleaningSoSMap) this.sos.getMap();
        availableAction.add(new Sweeping(this));

        MovingUp movingUp = new MovingUp(this);
        if (movingUp.checkPrecondition()) {
            availableAction.add(movingUp);
        }

        MovingDown movingDown = new MovingDown(this);
        if (movingDown.checkPrecondition()) {
            availableAction.add(movingDown);
        }

        MovingLeft movingLeft = new MovingLeft(this);
        if (movingLeft.checkPrecondition()) {
            availableAction.add(movingLeft);
        }

        MovingRight movingRight = new MovingRight(this);
        if (movingRight.checkPrecondition()) {
            availableAction.add(movingRight);
        }

        Random random = new Random();
        int target = random.nextInt(availableAction.size());

        selectedActionList.add(availableAction.get(target));
    }

    public void changeState() {

    }

    @Override
    public UpdateResult update(RunResult runResult) {
        UpdateResult updateResult = super.update(runResult);
        CleaningSoSObjectLocation curLoc = (CleaningSoSObjectLocation) this.getLocation();
        updateResult.addLog(curLoc.getX() + ", " + curLoc.getY() + ", " + curLoc.getFloor());
        return updateResult;
    }
}

package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.*;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.geo.Floor;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.CS;
import kr.ac.kaist.se.model.strc.Organization;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public abstract class Robot extends CS {

    public Robot(SoS sos, Organization organization, int x, int y, Floor floor){
        super(sos, organization);
        this.location = new CleaningSoSObjectLocation(x, y, floor);
        this.addAction(new MovingUp(this));
        this.addAction(new MovingDown(this));
        this.addAction(new MovingLeft(this));
        this.addAction(new MovingRight(this));
    }
}

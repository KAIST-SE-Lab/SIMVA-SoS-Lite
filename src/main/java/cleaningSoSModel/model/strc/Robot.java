package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.*;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.CS;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public abstract class Robot extends CS {
    protected CleaningSoSObjectLocation location;

    public Robot(SoS sos, int x, int y){
        super(sos);
        this.location = new CleaningSoSObjectLocation(x, y);
        this.addAction(new MovingUp(this));
        this.addAction(new MovingDown(this));
        this.addAction(new MovingLeft(this));
        this.addAction(new MovingRight(this));
    }

    public CleaningSoSObjectLocation getLocation() {
        return this.location;
    }
}

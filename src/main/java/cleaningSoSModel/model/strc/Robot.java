package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.Moving;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.strc.CS;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;

import java.util.ArrayList;

public abstract class Robot extends CS {
    protected CleaningSoSObjectLocation location;

    public Robot(SoS sos, int x, int y){
        super(sos);
        this.location = new CleaningSoSObjectLocation(x, y);
        this.actionList.add(new Moving(this, 0, 0));
    }

    public CleaningSoSObjectLocation getLocation() {
        return this.location;
    }
}

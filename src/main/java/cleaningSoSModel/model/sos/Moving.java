package cleaningSoSModel.model.sos;

import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import kr.ac.kaist.se.model.sos.Action;

public class Moving extends Action {
    private Robot target;
    private int xDiff;
    private int yDiff;

    public Moving(Robot target, int xDiff, int yDiff){
        this.target = target;
        this.xDiff = xDiff;
        this.yDiff = yDiff;
    }

    public void execution(){
        CleaningSoSObjectLocation curLoc = target.getLocation();
        curLoc.setX(curLoc.getX() + xDiff);
        curLoc.setY(curLoc.getY() + xDiff);
    }
}

package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.geo.CleaningSoSLocationInformation;
import cleaningSoSModel.model.geo.CleaningSoSMap;
import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.strc.Robot;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Action;

public abstract class Moving extends Action {
    private Robot target;
    private int xDiff;
    private int yDiff;

    public Moving(Robot target, int xDiff, int yDiff){
        this.name = "Moving " + target.getName();
        this.target = target;
        this.xDiff = xDiff;
        this.yDiff = yDiff;
    }

    @Override
    public float calcUtility(){
        return 0;
    }

    @Override
    public void executeAction(){
        CleaningSoSObjectLocation curLoc = (CleaningSoSObjectLocation) target.getLocation();
        curLoc.setX(curLoc.getX() + xDiff);
        curLoc.setY(curLoc.getY() + yDiff);
    }

    @Override
    public boolean checkPrecondition(){
        CleaningSoSMap cleaningSoSMap = (CleaningSoSMap) this.target.getSos().getMap();
        CleaningSoSObjectLocation curLoc = (CleaningSoSObjectLocation) target.getLocation();

        CleaningSoSObjectLocation newLoc = new CleaningSoSObjectLocation(curLoc.getX() + xDiff, curLoc.getY() + yDiff, curLoc.getFloor());

        if (cleaningSoSMap.isValidLocation(newLoc)){
            CleaningSoSLocationInformation newLocInfo = (CleaningSoSLocationInformation) cleaningSoSMap.getLocationInfo(newLoc);

            if(newLocInfo == null){
                return false;
            }

            for(_SimObject_ target: newLocInfo.getObjectArrayList()){
                if(target instanceof Robot){
                    return false;
                }
            }

            return !newLocInfo.isWall();
        }
        return false;
    }

    public int getXDiff() {
        return xDiff;
    }

    public int getYDiff() {
        return yDiff;
    }
}

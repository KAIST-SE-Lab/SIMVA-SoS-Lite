package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.strc.Robot;
import cleaningSoSModel.model.strc.Tile;
import kr.ac.kaist.se.model.behv.Action;

public class Sweeping extends Action {
    private Robot target;

    public Sweeping(Robot target){
        this.target = target;
        this.name = "Sweeping " + target.getName();
    }

    @Override
    public float calcUtility(){
        return 0;
    }

    @Override
    public void executeAction(){
        CleaningSoSObjectLocation curLoc = (CleaningSoSObjectLocation) this.target.getLocation();
        String targetName = "tile" + Integer.toString(curLoc.getX()) + Integer.toString(curLoc.getY()) + curLoc.getFloor();
        Tile tile = (Tile) this.target.getSos().searchPassiveEnvElement(targetName);

        tile.tryRemoveLevelOfDust(1);
    }

    @Override
    public boolean checkPrecondition(){
        return true;
    }
}

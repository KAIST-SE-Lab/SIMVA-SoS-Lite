package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.strc.OutdoorDust;
import cleaningSoSModel.model.strc.Tile;
import kr.ac.kaist.se.model.behv.Action;

import java.util.ArrayList;
import java.util.Random;

public class InflowDust extends Action {
    OutdoorDust outdoorDust;

    public InflowDust(OutdoorDust outdoorDust){
        this.outdoorDust = outdoorDust;
        this.name = "InflowDust";
    }

    @Override
    protected float calcUtility() {
        return 0;
    }

    @Override
    public void executeAction() {
        Random random = new Random();
        ArrayList<Tile> listOfTiles = outdoorDust.getListOfTiles();
        int target = random.nextInt(listOfTiles.size());

        listOfTiles.get(target).addLevelOfDust(1);
        this.name = "InflowDust " + listOfTiles.get(target).getName();
    }

    @Override
    protected boolean checkPrecondition() {
        return true;
    }
}

package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.InflowDust;
import kr.ac.kaist.se.model.strc.ActiveEnvElement;
import kr.ac.kaist.se.model.strc.Environment;
import kr.ac.kaist.se.model.strc.PassiveEnvElement;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;

import java.util.ArrayList;

public class OutdoorDust extends ActiveEnvElement {
    ArrayList<Tile> listOfTiles;

    public OutdoorDust(String name, Environment environment) {
        super(name, environment);
        listOfTiles = new ArrayList<Tile>(0);
        this.updateListOfTiles();
        this.addAction(new InflowDust(this));
    }

    public ArrayList<Tile> getListOfTiles() {
        return listOfTiles;
    }

    public void addListOfTiles(Tile tile){
        listOfTiles.add(tile);
    }

    public void removeListOfTiles(Tile tile){
        listOfTiles.remove(tile);
    }

    public void clearListOFTiles(){
        listOfTiles.clear();
    }

    public void updateListOfTiles(){
        this.clearListOFTiles();
        for (PassiveEnvElement passiveEnvElement: environment.getPassiveEnvElmtList()){
            if (passiveEnvElement instanceof Tile){
                listOfTiles.add((Tile) passiveEnvElement);
            }
        }
    }

    public RunResult run() {
        return super.run();
    }
}

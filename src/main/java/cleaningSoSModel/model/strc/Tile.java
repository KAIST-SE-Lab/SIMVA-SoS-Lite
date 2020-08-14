package cleaningSoSModel.model.strc;

import kr.ac.kaist.se.model.strc.Environment;
import kr.ac.kaist.se.model.strc.PassiveEnvElement;

public class Tile extends PassiveEnvElement {
    protected int levelOfDust;

    public Tile(String name, Environment environment) {
        super(name, environment);
        this.levelOfDust = 10;
    }

    public void addLevelOfDust(int num){
        levelOfDust = levelOfDust + num;
    }

    public void tryRemoveLevelOfDust(int num){
        if (num < levelOfDust){
            levelOfDust = levelOfDust - num;
        }
        else {
            levelOfDust = 0;
        }
    }
}

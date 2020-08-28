package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.geo.Floor;
import kr.ac.kaist.se.model.strc.Environment;
import kr.ac.kaist.se.model.strc.PassiveEnvElement;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class Tile extends PassiveEnvElement {
    protected int levelOfDust;

    public Tile(String name, int x, int y, Floor floor, Environment environment) {
        super(name, environment);
        this.levelOfDust = 10;
        this.location = new CleaningSoSObjectLocation(x, y, floor);
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

    public UpdateResult update(RunResult runResult) {
        UpdateResult updateResult = super.update(runResult);
        updateResult.addLog(Integer.toString(this.levelOfDust));
        return updateResult;
    }
}

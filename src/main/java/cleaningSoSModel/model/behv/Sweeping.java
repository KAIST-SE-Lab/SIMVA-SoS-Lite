package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.strc.Robot;
import kr.ac.kaist.se.model.behv.Action;

public class Sweeping extends Action {
    private Robot target;

    public Sweeping(Robot target){
        this.target = target;
    }

    @Override
    public float calcUtility(){
        return 0;
    }

    @Override
    public void executeAction(){
    }

    @Override
    public boolean checkPrecondition(){
        return true;
    }
}

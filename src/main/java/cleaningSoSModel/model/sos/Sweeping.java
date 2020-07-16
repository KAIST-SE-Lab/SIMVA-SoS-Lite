package cleaningSoSModel.model.sos;

import kr.ac.kaist.se.model.sos.Action;

public class Sweeping extends Action {
    private Robot target;

    public Sweeping(Robot target){
        this.target = target;
    }
}

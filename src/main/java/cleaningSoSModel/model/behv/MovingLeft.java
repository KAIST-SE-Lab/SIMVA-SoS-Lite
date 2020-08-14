package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.strc.Robot;

public class MovingLeft extends Moving {

    public MovingLeft(Robot target) {
        super(target, -1, 0);
        this.name = "MovingLeft " + target.getName();
    }
}

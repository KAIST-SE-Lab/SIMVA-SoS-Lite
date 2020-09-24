package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.strc.Robot;

public class MovingRight extends Moving {

    public MovingRight(Robot target) {
        super(target, 1, 0);
        this.name = "MovingRight " + target.getName();
    }
}

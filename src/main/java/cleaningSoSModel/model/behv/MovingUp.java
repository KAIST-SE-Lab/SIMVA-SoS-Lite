package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.strc.Robot;

public class MovingUp extends Moving {

    public MovingUp(Robot target) {
        super(target, 0, 1);
        this.name = "MovingUp " + target.getName();
    }
}

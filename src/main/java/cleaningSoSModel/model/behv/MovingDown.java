package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.strc.Robot;

public class MovingDown extends Moving {

    public MovingDown(Robot target) {
        super(target, 0, -1);
    }
}

package simpleModel.model.sos;

import kr.ac.kaist.se.model.sos.CS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public class SimpleCS2 extends CS {
    public int val;

    public SimpleCS2() {
        this.val = 0;
    }

    @Override
    public void doAction() {
        System.out.println("Start simpleModel.simpleCS2.doAction()");

        System.out.println("End simpleModel.simpleCS2.doAction()");
    }

    @Override
    public void doDecisionMaking() {
        System.out.println("Start simpleModel.simpleCS2.doDecisionMaking()");
        System.out.println("End simpleModel.simpleCS2.doDecisionMaking()");
    }

    @Override
    public ArrayList<RunResult> run() {
        System.out.println("Start simpleModel.simpleCS2.run()");
        doDecisionMaking();
        System.out.println("End simpleModel.simpleCS2.run()");
        return new ArrayList<RunResult>(0);
    }

    @Override
    public ArrayList<UpdateResult> update() {
        System.out.println("Start simpleModel.simpleCS2.update()");
        doAction();
        System.out.println("End simpleModel.simpleCS2.update()");
        return new ArrayList<UpdateResult>(0);
    }

    @Override
    public void changeState() {

    }
}

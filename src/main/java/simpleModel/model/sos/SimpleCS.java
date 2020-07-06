package simpleModel.model.sos;

import kr.ac.kaist.se.model.sos.CS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public class SimpleCS extends CS {
    public SimpleCS() {

    }

    @Override
    public void doAction() {
        System.out.println("Start simpleModel.simpleCS.doAction()");
        System.out.println("End simpleModel.simpleCS.doAction()");
    }

    @Override
    public void doDecisionMaking() {
        System.out.println("Start simpleModel.simpleCS.doDecisionMaking()");
        System.out.println("End simpleModel.simpleCS.doDecisionMaking()");
    }

    @Override
    public ArrayList<RunResult> run() {
        System.out.println("Start simpleModel.simpleCS.run()");
        doDecisionMaking();
        System.out.println("End simpleModel.simpleCS.run()");
        return new ArrayList<RunResult>(0);
    }

    @Override
    public ArrayList<UpdateResult> update() {
        System.out.println("Start simpleModel.simpleCS.update()");
        doAction();
        System.out.println("End simpleModel.simpleCS.update()");
        return new ArrayList<UpdateResult>(0);
    }

    @Override
    public void changeState() {

    }
}

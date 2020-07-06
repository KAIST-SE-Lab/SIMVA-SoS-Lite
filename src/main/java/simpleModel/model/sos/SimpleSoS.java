package simpleModel.model.sos;

import kr.ac.kaist.se.model.sos.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public class SimpleSoS extends SoS {
    public SimpleSoS(){
        super();
    }

    @Override
    public ArrayList<RunResult> run() {
        System.out.println("Start SimpleSoS.run()");

        ArrayList<RunResult> runResults = super.run();

        System.out.println("End SimpleSoS.run()");
        return runResults;
    }

    @Override
    public ArrayList<UpdateResult> update() {
        System.out.println("Start SimpleSoS.update()");

        ArrayList<UpdateResult> updateResults = super.update();

        System.out.println("End SimpleSoS.update()");
        return updateResults;
    }
}

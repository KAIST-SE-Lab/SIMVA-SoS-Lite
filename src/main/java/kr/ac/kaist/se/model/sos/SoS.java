package kr.ac.kaist.se.model.sos;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

abstract public class SoS extends _SimObject_ {
    public ArrayList<CS> sos_csList;

    public SoS(){
        sos_csList = new ArrayList<CS>(0);
    }

    @Override
    public ArrayList<RunResult> run() {
        System.out.println("Start SoS.run()");

        ArrayList<RunResult> runResults = new ArrayList<RunResult>(0);

        for(CS cs: sos_csList) {
            runResults.addAll(cs.run());
        }

        System.out.println("End SoS.run()");
        return runResults;
    }

    @Override
    public ArrayList<UpdateResult> update() {
        System.out.println("Start SoS.update()");

        ArrayList<UpdateResult> updateResults = new ArrayList<UpdateResult>(0);

        for(CS cs: sos_csList) {
            updateResults.addAll(cs.update());
        }

        System.out.println("End SoS.update()");
        return updateResults;
    }
}

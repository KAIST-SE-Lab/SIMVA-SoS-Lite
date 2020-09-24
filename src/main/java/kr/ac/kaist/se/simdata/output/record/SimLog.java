package kr.ac.kaist.se.simdata.output.record;

import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public class SimLog {
    ArrayList<UpdateResult> updateResultList;

    public SimLog() {
        this.updateResultList = new ArrayList<UpdateResult>(0);
    }

    public ArrayList<UpdateResult> getUpdateResult() {
        return updateResultList;
    }

    public void addUpdateResult(UpdateResult updateResult) {
        updateResultList.add(updateResult);
    }
}

package kr.ac.kaist.se.simdata.output.intermediate;

import java.util.ArrayList;

public class UpdateResult {
    ArrayList<String> log;

    public UpdateResult(String log){
        this.log = new ArrayList<String>(0);
        this.log.add(log);
    }

    public ArrayList<String> getLog() {
        return log;
    }

    public void addLog(String log) {
        this.log.add(log);
    }

    public void addAllLog(ArrayList<String> log) {
        this.log.addAll(log);
    }
}

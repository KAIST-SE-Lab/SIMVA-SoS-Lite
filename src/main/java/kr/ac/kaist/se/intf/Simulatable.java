package kr.ac.kaist.se.intf;

import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

public interface Simulatable {
    ArrayList<RunResult> run();
    ArrayList<UpdateResult> update();
}

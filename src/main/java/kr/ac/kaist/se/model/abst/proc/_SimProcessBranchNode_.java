package kr.ac.kaist.se.model.abst.proc;

import java.util.ArrayList;

abstract public class _SimProcessBranchNode_ extends _SimProcessNode_ {

    protected String condition;

    protected ArrayList<_SimProcessEdge_> ifNodes;
    protected ArrayList<_SimProcessEdge_> elseNodes;
}

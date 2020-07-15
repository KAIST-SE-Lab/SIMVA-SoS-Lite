package kr.ac.kaist.se.model.abst.proc;

import java.util.ArrayList;

abstract public class _SimProcessBranchNode_ extends _SimProcessNode_{

    String condition;

    ArrayList<_SimProcessEdge_> ifNodes;
    ArrayList<_SimProcessEdge_> elseNodes;
}

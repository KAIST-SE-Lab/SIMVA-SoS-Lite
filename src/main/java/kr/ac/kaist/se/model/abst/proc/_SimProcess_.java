package kr.ac.kaist.se.model.abst.proc;

import java.util.ArrayList;

abstract public class _SimProcess_ {

    protected String procId;

    protected ArrayList<_SimProcessNode_> nodeList;
    protected ArrayList<_SimProcessEdge_> edgeList;

    protected ArrayList<_SimProcess_> subProcList;    //Subprocesses


}

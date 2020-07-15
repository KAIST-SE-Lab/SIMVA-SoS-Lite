package kr.ac.kaist.se.model.abst.proc;

import java.util.ArrayList;

abstract public class _SimProcess_ {

    String procId;

    ArrayList<_SimProcessNode_> nodeList;
    ArrayList<_SimProcessEdge_> edgeList;

    ArrayList<_SimProcess_> subProcList;    //Subprocesses


}

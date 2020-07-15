package kr.ac.kaist.se.model.abst.proc;

import java.util.ArrayList;

abstract public class _SimProcessEdge_ {
    String edgeId;

    String label;

    _SimProcessNode_ fromNode;
    ArrayList<_SimProcessNode_> toNodes;
}

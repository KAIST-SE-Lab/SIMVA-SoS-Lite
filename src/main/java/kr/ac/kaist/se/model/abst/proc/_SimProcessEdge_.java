package kr.ac.kaist.se.model.abst.proc;

import java.util.ArrayList;

abstract public class _SimProcessEdge_ {
    protected String edgeId;

    protected String label;

    protected _SimProcessNode_ fromNode;
    protected ArrayList<_SimProcessNode_> toNodes;
}

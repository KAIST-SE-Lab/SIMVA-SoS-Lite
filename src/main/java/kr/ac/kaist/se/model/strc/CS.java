package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.DecisionMakable;

import java.util.ArrayList;

abstract public class CS extends SystemEntity implements DecisionMakable {
    //TODO: Using HashMap or HashTable
    protected ArrayList<InformationData> knowledgeBase;
}

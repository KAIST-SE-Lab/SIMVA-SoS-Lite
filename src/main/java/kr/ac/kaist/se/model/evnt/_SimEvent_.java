package kr.ac.kaist.se.model.evnt;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

public class _SimEvent_ {

    //TODO: direct reference to an object
    _SimObject_ targetObj;
    String targetObjId;

    EnumEventTargetScope targetScope;

    //Temporal properties
    int timebase;
    int duration;
    int period;
    EnumOccPattern occPattern;

    //Geographical properties
    //TODO: consistency with object location and map

    //Probabilistic properties
    boolean isProbabilistic;
    EnumProbDistribution probDist;  //Probability distribution
    float probDistValue;
    float probValue;    //Probability
    String probExp;     //Probability expression

}

package kr.ac.kaist.se.simdata.input;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.evnt.EnumEventTargetScope;
import kr.ac.kaist.se.model.evnt.EnumOccPattern;
import kr.ac.kaist.se.model.evnt.EnumProbDistribution;
import kr.ac.kaist.se.model.evnt._SimEvent_;

public class SimScenarioEvent extends _SimEvent_ {

    //ScenarioEvent should have a specific target object (or scope of objects)
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

    //Probabilistic properties
    boolean isProbabilistic;
    EnumProbDistribution probDist;  //Probability distribution
    float probDistValue;
    float probValue;    //Probability
    String probExp;     //Probability expression

    //TODO: scenario execution
}

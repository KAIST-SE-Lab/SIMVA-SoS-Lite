package kr.ac.kaist.se.simdata.input;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.evnt.EnumEventTargetScope;
import kr.ac.kaist.se.model.evnt.EnumOccPattern;
import kr.ac.kaist.se.model.evnt.EnumProbDistribution;
import kr.ac.kaist.se.model.evnt._SimEvent_;

public class SimScenarioEvent extends _SimEvent_ {

    //ScenarioEvent should have a specific target object (or scope of objects)
    //TODO: direct reference to an object
    protected _SimObject_ targetObj;
    protected String targetObjId;

    protected EnumEventTargetScope targetScope;


    //Temporal properties
    protected int timebase;
    protected int duration;
    protected int period;
    protected EnumOccPattern occPattern;

    //Geographical properties

    //Probabilistic properties
    protected boolean isProbabilistic;
    protected EnumProbDistribution probDist;  //Probability distribution
    protected float probDistValue;
    protected float probValue;    //Probability
    protected String probExp;     //Probability expression

    //TODO: scenario execution
}

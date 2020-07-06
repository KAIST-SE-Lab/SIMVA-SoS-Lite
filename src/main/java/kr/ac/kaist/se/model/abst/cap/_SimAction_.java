package kr.ac.kaist.se.model.abst.cap;

abstract public class _SimAction_ {
    String id;
    String tag;
    String name;

    int duration;
    float cost;
    float benefit;

    abstract float calcUtility();
    abstract void executeAction(); //TODO: set return
    abstract boolean checkPrecondition(); //TODO: where to define the precondition
}

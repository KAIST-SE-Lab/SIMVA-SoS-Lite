package kr.ac.kaist.se.model.abst.cap;

abstract public class _SimAction_ {
    protected String id;
    protected String tag;
    protected String name;

    protected int duration;
    protected float cost;
    protected float benefit;

    abstract protected float calcUtility();

    abstract public void executeAction(); //TODO: set return

    abstract protected boolean checkPrecondition(); //TODO: where to define the precondition

    public String getName() {
        return name;
    }
}

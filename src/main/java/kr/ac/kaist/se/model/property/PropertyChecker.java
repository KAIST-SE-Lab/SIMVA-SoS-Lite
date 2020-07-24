package kr.ac.kaist.se.model.property;

import kr.ac.kaist.se.simdata.output.record.SimLog;
import kr.ac.kaist.se.simdata.output.record.SimSnapshot;

public abstract class PropertyChecker {
    protected abstract boolean evaluateState(SimSnapshot snapshot, Property verificationProperty);
    protected abstract boolean evaluateState(SimLog log, Property verificationProperty);
    public abstract boolean check(SimLog log, Property verificationProperty);
    public abstract boolean check(SimLog log, Property verificationProperty, int until);
    public abstract boolean check(SimLog log, Property verificationProperty, double prob, int T);
    public abstract boolean check(SimLog log, Property verificationProperty, double prob, int t, int T);
    public abstract boolean check(SimLog log, Property verificationProperty, int t, int T);
}

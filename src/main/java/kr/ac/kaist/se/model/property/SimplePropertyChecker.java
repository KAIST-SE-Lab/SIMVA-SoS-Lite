package kr.ac.kaist.se.model.property;

import kr.ac.kaist.se.simdata.output.record.SimLog;
import kr.ac.kaist.se.simdata.output.record.SimSnapshot;

public class SimplePropertyChecker extends PropertyChecker {
    @Override
    protected boolean evaluateState(SimSnapshot snapshot, Property verificationProperty) {
        return false;
    }

    @Override
    protected boolean evaluateState(SimLog log, Property verificationProperty) {
        return false;
    }

    @Override
    public boolean check(SimLog log, Property verificationProperty) {
        return false;
    }

    @Override
    public boolean check(SimLog log, Property verificationProperty, int until) {
        return false;
    }

    @Override
    public boolean check(SimLog log, Property verificationProperty, double prob, int T) {
        return false;
    }

    @Override
    public boolean check(SimLog log, Property verificationProperty, double prob, int t, int T) {
        return false;
    }

    @Override
    public boolean check(SimLog log, Property verificationProperty, int t, int T) {
        return false;
    }
}

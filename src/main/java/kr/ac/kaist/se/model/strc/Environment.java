package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

abstract public class Environment extends _SimObject_ {
    protected SoS sos;
    protected EnumEnvType envType;

    protected ArrayList<ActiveEnvElement> activeEnvElmtList;
    protected ArrayList<PassiveEnvElement> passiveEnvElmtList;

    public Environment(String name, SoS sos){
        this.name = name;
        this.sos = sos;
        sos.addEnvironment(this);
        this.activeEnvElmtList = new ArrayList<ActiveEnvElement>(0);
        this.passiveEnvElmtList = new ArrayList<PassiveEnvElement>(0);
    }

    public ArrayList<ActiveEnvElement> getActiveEnvElmtList() {
        return activeEnvElmtList;
    }

    public void addActiveEnvElement(ActiveEnvElement activeEnvElement){
        this.activeEnvElmtList.add(activeEnvElement);
    }

    public void removeActiveEnvElement(ActiveEnvElement activeEnvElement){
        this.activeEnvElmtList.remove(activeEnvElement);
    }

    public ArrayList<PassiveEnvElement> getPassiveEnvElmtList() {
        return passiveEnvElmtList;
    }

    public void addPassiveEnvElement(PassiveEnvElement passiveEnvElement){
        this.passiveEnvElmtList.add(passiveEnvElement);
    }

    public void removePassiveEnvElement(PassiveEnvElement passiveEnvElement){
        this.passiveEnvElmtList.remove(passiveEnvElement);
    }

    public RunResult run() {
        RunResult runResult = new RunResult(this, new ArrayList<_SimAction_>(0));
        for(ActiveEnvElement activeEnvElement: this.activeEnvElmtList) {
            runResult.addChildRunResult(activeEnvElement.run());
        }
        for(PassiveEnvElement passiveEnvElement: this.passiveEnvElmtList) {
            runResult.addChildRunResult(passiveEnvElement.run());
        }
        return runResult;
    }

    public UpdateResult update(RunResult runResult) {
        UpdateResult updateResult = new UpdateResult(this.name);

        for(RunResult childRunResult: runResult.getChildRunResults()) {
            if (childRunResult.getTarget() instanceof ActiveEnvElement){
                ActiveEnvElement target = (ActiveEnvElement) childRunResult.getTarget();
                UpdateResult updateResult1 = target.update(childRunResult);
                updateResult.addAllLog(updateResult1.getLog());
            }
            if (childRunResult.getTarget() instanceof PassiveEnvElement){
                PassiveEnvElement target = (PassiveEnvElement) childRunResult.getTarget();
                UpdateResult updateResult1 = target.update(childRunResult);
                updateResult.addAllLog(updateResult1.getLog());
            }
        }
        return updateResult;
    }

    public ActiveEnvElement searchActiveEnvElement(String name){
        for(ActiveEnvElement activeEnvElement : this.activeEnvElmtList){
            if (activeEnvElement.getName().equals(name)){
                return activeEnvElement;
            }
        }
        return null;
    }

    public PassiveEnvElement searchPassiveEnvElement(String name){
        for(PassiveEnvElement passiveEnvElement : this.passiveEnvElmtList){
            if (passiveEnvElement.getName().equals(name)){
                return passiveEnvElement;
            }
        }
        return null;
    }
}

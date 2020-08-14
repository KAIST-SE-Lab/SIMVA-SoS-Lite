package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

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
}

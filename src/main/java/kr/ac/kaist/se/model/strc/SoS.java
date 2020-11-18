package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.behv.Task;
import kr.ac.kaist.se.model.geo.Map;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.lang.reflect.Array;
import java.util.ArrayList;

abstract public class SoS extends _SimObject_ {

    //High-level containers
    protected ArrayList<Organization> orgList;
    protected ArrayList<Infrastructure> infraList;
    protected ArrayList<Environment> envList;

    //All member constituents
    protected ArrayList<CS> csList;

    //All tasks
    protected ArrayList<Task> taskList;

    //Infrastructure entities
    protected ArrayList<SystemEntity> systemEntityList;
    protected ArrayList<ResourceEntity> resourceEntityList;
    protected ArrayList<ServiceEntity> serviceEntityList;

    //Environment entities
    protected ArrayList<ActiveEnvElement> activeEnvElmtList;
    protected ArrayList<PassiveEnvElement> passiveEnvElmtList;

    protected Map map;

    public SoS(String name) {
        this.name = name;
        this.orgList = new ArrayList<Organization>(0);
        this.csList = new ArrayList<CS>(0);
        this.envList = new ArrayList<Environment>(0);
    }

    public RunResult run(){
        RunResult runResult = new RunResult(this, new ArrayList<_SimAction_>(0));
        for(Organization organization: this.orgList) {
            runResult.addChildRunResult(organization.run());
        }
        for(Environment environment: this.envList) {
            runResult.addChildRunResult(environment.run());
        }
        return runResult;
    }

    public UpdateResult update(RunResult runResult){
        UpdateResult updateResult = new UpdateResult(this.name);
        for(RunResult childRunResult: runResult.getChildRunResults()) {
            if (childRunResult.getTarget() instanceof Organization){
                Organization target = (Organization) childRunResult.getTarget();
                UpdateResult updateResult1 = target.update(childRunResult);
                updateResult.addAllLog(updateResult1.getLog());
            }
            if (childRunResult.getTarget() instanceof Environment){
                Environment target = (Environment) childRunResult.getTarget();
                UpdateResult updateResult1 = target.update(childRunResult);
                updateResult.addAllLog(updateResult1.getLog());
            }
        }
        return updateResult;
    }

    public void addOrg(Organization organization) {
        orgList.add(organization);
    }

    public void removeOrg(Organization organization) {
        orgList.remove(organization);
    }

    public void addCS(CS cs) {
        csList.add(cs);
    }

    public void removeCS(CS cs) {
        csList.remove(cs);
    }

    public CS searchCS(String name){
        for(CS cs : this.csList){
            if (cs.getName().equals(name)){
                return cs;
            }
        }
        return null;
    }

    public void addEnvironment(Environment environment) {
        this.envList.add(environment);
    }

    public void removeEnvironment(Environment environment) {
        this.envList.remove(environment);
    }

    public Map getMap() {
        return map;
    }

    public ActiveEnvElement searchActiveEnvElement(String name){
        for(Environment environment : this.envList){
            for(ActiveEnvElement activeEnvElement: environment.activeEnvElmtList){
                if (activeEnvElement.getName().equals(name)){
                    return activeEnvElement;
                }
            }
        }
        return null;
    }

    public PassiveEnvElement searchPassiveEnvElement(String name){
        for(Environment environment : this.envList){
            for(PassiveEnvElement passiveEnvElement: environment.passiveEnvElmtList){
                if (passiveEnvElement.getName().equals(name)){
                    return passiveEnvElement;
                }
            }
        }
        return null;
    }

    public void updateMapObjectLocationArrayListHashMap(){
        this.map.clearObjectLocationArrayListHashMap();

        for(CS cs: this.csList){
            this.map.addObjectLocationArrayListHashMap(cs.getLocation(), cs);
        }

        for(Environment environment: this.envList){
            for(PassiveEnvElement passiveEnvElement: environment.passiveEnvElmtList){
                this.map.addObjectLocationArrayListHashMap(passiveEnvElement.getLocation(), passiveEnvElement);
            }
        }
    }
}

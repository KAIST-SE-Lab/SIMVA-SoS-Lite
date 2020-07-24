package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Action;
import kr.ac.kaist.se.model.behv.Task;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

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
    protected ArrayList<EnvElement> envElmtList;

    public SoS() {
        this.orgList = new ArrayList<Organization>(0);
        this.csList = new ArrayList<CS>(0);
    }

    public RunResult run(){
        RunResult runResult = new RunResult(this, new ArrayList<_SimAction_>(0));
        for(Organization organization: this.orgList) {
            runResult.addChildRunResult(organization.run());
        }
        return runResult;
    }

    public UpdateResult update(RunResult runResult){
        for(RunResult childRunResult: runResult.getChildRunResults()) {
            _SimObject_ target = childRunResult.getTarget();
            target.update(childRunResult);
        }
        return null;
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
}

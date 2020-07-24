package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Role;
import kr.ac.kaist.se.model.behv.Task;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

abstract public class Organization extends _SimObject_ {

    protected SoS soS;
    protected Organization parentOrganization;

    protected EnumOrgType orgType;

    protected ArrayList<Organization> subOrgList; //Suborganizations
    protected ArrayList<CS> csList;               //Member CSs
    protected ArrayList<CS> directCsList;
    protected ArrayList<Task> taskList;           //List of all tasks included in this org
    protected ArrayList<Role> roleList;           //List of all roles included in this org

    public Organization(SoS soS) {
        this.soS = soS;
        this.subOrgList = new ArrayList<Organization>(0);
        this.csList = new ArrayList<CS>(0);
        this.directCsList = new ArrayList<CS>(0);
    }

    public RunResult run(){
        RunResult runResult = new RunResult(this, new ArrayList<_SimAction_>(0));
        for(Organization organization: this.subOrgList) {
            runResult.addChildRunResult(organization.run());
        }
        for(CS cs: this.directCsList) {
            runResult.addChildRunResult(cs.run());
        }
        return runResult;
    }

    public UpdateResult update(RunResult runResult){
        for(RunResult childRunResult: runResult.getChildRunResults()) {
            if (childRunResult.getTarget() instanceof Organization){
                Organization target = (Organization) childRunResult.getTarget();
                target.update(childRunResult);
            }
            else {
                CS target = (CS) childRunResult.getTarget();
                target.update(childRunResult);
            }
        }
        return null;
    }

    public SoS getSoS() {
        return soS;
    }

    public void setSoS(SoS soS) {
        this.soS = soS;
    }

    public Organization getParentOrganization() {
        return parentOrganization;
    }

    public void setParentOrganization(Organization parentOrganization) {
        this.parentOrganization = parentOrganization;
    }

    public ArrayList<Organization> getSubOrgList() {
        return subOrgList;
    }

    public void addSubOrg(Organization organization) {
        this.subOrgList.add(organization);
    }

    public void removeSubOrg(Organization organization) {
        this.subOrgList.remove(organization);
    }

    public ArrayList<CS> getCsList() {
        return csList;
    }

    public void addCs(CS cs) {
        if (parentOrganization != null) {
            if (!parentOrganization.isContainedCs(cs)) {
                return;
            }
            if (parentOrganization.isContainedDirectCs(cs)) {
                parentOrganization.removeDirectCs(cs);
            }
        }

        this.csList.add(cs);
    }

    public void removeCs(CS cs) {
        this.csList.remove(cs);

        if (isContainedDirectCs(cs)) {
            this.removeDirectCs(cs);
        }
        else {
            for (Organization organization: this.subOrgList) {
                if (organization.isContainedCs(cs)) {
                    organization.removeCs(cs);
                }
            }
        }

        if (parentOrganization != null) {
            parentOrganization.tryAddDirectCs(cs);
        }
    }

    public boolean isContainedCs(CS cs) {
        return this.csList.contains(cs);
    }

    public ArrayList<CS> getDirectCsList() {
        return directCsList;
    }

    public void addDirectCs(CS cs) {
        this.directCsList.add(cs);
    }

    public void tryAddDirectCs(CS cs) {
        if (!this.isSubOrgContains(cs)) {
            this.addDirectCs(cs);
        }
    }

    public void removeDirectCs(CS cs) {
        this.directCsList.remove(cs);
    }

    public boolean isContainedDirectCs(CS cs) {
        return this.directCsList.contains(cs);
    }

    public boolean isSubOrgContains(CS cs) {
        for (Organization organization: this.subOrgList) {
            if (organization.isContainedCs(cs)) {
                return true;
            }
        }
        return true;
    }
}

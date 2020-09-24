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
    protected ArrayList<CS> directCSList;
    protected ArrayList<Task> taskList;           //List of all tasks included in this org
    protected ArrayList<Role> roleList;           //List of all roles included in this org

    public Organization(String name, SoS soS) {
        this.name = name;
        this.soS = soS;
        soS.addOrg(this);

        this.subOrgList = new ArrayList<Organization>(0);
        this.csList = new ArrayList<CS>(0);
        this.directCSList = new ArrayList<CS>(0);
    }

    public RunResult run(){
        RunResult runResult = new RunResult(this, new ArrayList<_SimAction_>(0));
        for(Organization organization: this.subOrgList) {
            runResult.addChildRunResult(organization.run());
        }
        for(CS cs: this.directCSList) {
            runResult.addChildRunResult(cs.run());
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
            else {
                CS target = (CS) childRunResult.getTarget();
                UpdateResult updateResult1 = target.update(childRunResult);
                updateResult.addAllLog(updateResult1.getLog());
            }
        }
        return updateResult;
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

    public ArrayList<CS> getCSList() {
        return csList;
    }

    public void addCS(CS cs) {
        if (parentOrganization != null) {
            if (!parentOrganization.isContainedCS(cs)) {
                return;
            }
            if (parentOrganization.isContainedDirectCS(cs)) {
                parentOrganization.removeDirectCS(cs);
            }
        }

        this.csList.add(cs);
        this.directCSList.add(cs);
    }

    public void removeCS(CS cs) {
        this.csList.remove(cs);

        if (isContainedDirectCS(cs)) {
            this.removeDirectCS(cs);
        }
        else {
            for (Organization organization: this.subOrgList) {
                if (organization.isContainedCS(cs)) {
                    organization.removeCS(cs);
                }
            }
        }

        if (parentOrganization != null) {
            parentOrganization.tryAddDirectCS(cs);
        }
    }

    public boolean isContainedCS(CS cs) {
        return this.csList.contains(cs);
    }

    public ArrayList<CS> getDirectCSList() {
        return directCSList;
    }

    public void addDirectCS(CS cs) {
        this.directCSList.add(cs);
    }

    public void tryAddDirectCS(CS cs) {
        if (!this.isSubOrgContains(cs)) {
            this.addDirectCS(cs);
        }
    }

    public void removeDirectCS(CS cs) {
        this.directCSList.remove(cs);
    }

    public boolean isContainedDirectCS(CS cs) {
        return this.directCSList.contains(cs);
    }

    public boolean isSubOrgContains(CS cs) {
        for (Organization organization: this.subOrgList) {
            if (organization.isContainedCS(cs)) {
                return true;
            }
        }
        return true;
    }
}

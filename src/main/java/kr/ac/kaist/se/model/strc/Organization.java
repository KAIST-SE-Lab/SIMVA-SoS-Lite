package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Role;
import kr.ac.kaist.se.model.behv.Task;

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

    public Organization() {
        this.subOrgList = new ArrayList<Organization>(0);
        this.csList = new ArrayList<CS>(0);
        this.directCsList = new ArrayList<CS>(0);
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
        this.csList.add(cs);
    }

    public void removeCs(CS cs) {
        this.csList.remove(cs);
    }

    public ArrayList<CS> getDirectCsList() {
        return directCsList;
    }

    public void addDirectCs(CS cs) {
        this.directCsList.add(cs);
    }

    public void removeDirectCs(CS cs) {
        this.directCsList.remove(cs);
    }
}

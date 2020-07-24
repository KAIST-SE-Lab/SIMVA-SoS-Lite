package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.DecisionMakeable;

import java.util.ArrayList;

abstract public class CS extends SystemEntity implements DecisionMakeable {
    protected SoS soS;
    protected ArrayList<Organization> belongedOrganizationList;

    //TODO: Using HashMap or HashTable
    protected ArrayList<InformationData> knowledgeBase;

    public CS (SoS soS) {
        this.soS = soS;
        soS.addCS(this);

        this.belongedOrganizationList = new ArrayList<Organization>(0);
    }

    public SoS getSoS() {
        return soS;
    }

    public void setSoS(SoS soS) {
        this.soS = soS;
    }

    public ArrayList<Organization> getBelongedOrganizationList() {
        return belongedOrganizationList;
    }

    public void addBelongedOrganization(Organization organization) {
        this.belongedOrganizationList.add(organization);
        organization.addCs(this);
    }

    public void removeBelongedOrganization(Organization organization) {
        this.belongedOrganizationList.remove(organization);
        organization.removeCs(this);
    }
}

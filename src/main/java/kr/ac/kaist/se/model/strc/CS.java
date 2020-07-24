package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.DecisionMakeable;
import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

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
        this.actionList = new ArrayList<_SimAction_>(0);
        this.selectedActionList = new ArrayList<_SimAction_>(0);
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

    @Override
    public RunResult run() {
        this.selectActions();
        return new RunResult(this, this.selectedActionList);
    }

    @Override
    public UpdateResult update(RunResult runResult) {
        for (_SimAction_ selectedAction: runResult.getSelectedActionList()) {
            doAction(selectedAction);
        }
        return null;
    }

    @Override
    public void doAction(_SimAction_ action){
        action.executeAction();
    }
}

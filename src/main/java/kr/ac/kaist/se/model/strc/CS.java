package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.DecisionMakeable;
import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

import java.util.ArrayList;

abstract public class CS extends SystemEntity implements DecisionMakeable {
    protected SoS sos;
    protected Organization organization;

    //TODO: Using HashMap or HashTable
    protected ArrayList<InformationData> knowledgeBase;

    public CS (SoS sos, Organization organization) {
        this.sos = sos;
        sos.addCS(this);

        this.organization = organization;
        organization.addCS(this);

        this.actionList = new ArrayList<_SimAction_>(0);
        this.selectedActionList = new ArrayList<_SimAction_>(0);
    }

    public SoS getSos() {
        return sos;
    }

    public void setSos(SoS sos) {
        this.sos = sos;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
        organization.addCS(this);
    }

    public RunResult run() {
        this.clearSelectedAction();
        this.doDecisionMaking();
        return new RunResult(this, this.selectedActionList);
    }

    public UpdateResult update(RunResult runResult) {
        UpdateResult updateResult = new UpdateResult(this.name);

        for (_SimAction_ selectedAction: runResult.getSelectedActionList()) {
            doAction(selectedAction);
            updateResult.addLog(selectedAction.getName());
        }
        return updateResult;
    }

    public void doAction(_SimAction_ action){
        action.executeAction();
    }
}

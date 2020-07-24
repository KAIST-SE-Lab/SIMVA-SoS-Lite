package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.Possessable;
import kr.ac.kaist.se.model.abst.sys._SimActionableObject_;

import java.util.ArrayList;

abstract public class ServiceEntity extends _SimActionableObject_ implements Possessable {

    protected String serviceDesc;
    protected String serviceProviderId;

    protected ArrayList<SystemEntity> reqSysEntities;

    //TODO: Service interface
    //Service interface
}

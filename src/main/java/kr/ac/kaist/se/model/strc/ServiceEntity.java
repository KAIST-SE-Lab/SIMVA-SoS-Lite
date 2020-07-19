package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.intf.Occupiable;
import kr.ac.kaist.se.model.abst.sys._SimActionableObject_;

import java.util.ArrayList;

abstract public class ServiceEntity extends _SimActionableObject_ implements Occupiable {

    String serviceDesc;
    String serviceProviderId;

    ArrayList<SystemEntity> reqSysEntities;

    //TODO: Service interface
    //Service interface
}

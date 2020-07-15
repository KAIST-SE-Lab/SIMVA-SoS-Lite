package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Task;

import java.util.ArrayList;

abstract public class SoS extends _SimObject_ {

    //High-level containers
    ArrayList<Organization> orgList;
    ArrayList<Infrastructure> infraList;
    ArrayList<Environment> envList;

    //All member constituents
    ArrayList<CS> csList;

    //All tasks
    ArrayList<Task> taskList;

    //Infrastructure entities
    ArrayList<SystemEntity> systemEntityList;
    ArrayList<ResourceEntity> resourceEntityList;
    ArrayList<ServiceEntity> serviceEntityList;

    //Environment entities
    ArrayList<EnvElement> envElmtList;
}

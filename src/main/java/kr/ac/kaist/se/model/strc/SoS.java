package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Task;

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
}
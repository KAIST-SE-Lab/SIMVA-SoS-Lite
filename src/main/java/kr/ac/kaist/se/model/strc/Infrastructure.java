package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

import java.util.ArrayList;

abstract public class Infrastructure extends _SimObject_ {

    protected EnumInfraType infraType;

    protected ArrayList<SystemEntity> systemEntityList;
    protected ArrayList<ServiceEntity> serviceEntityList;
    protected ArrayList<ResourceEntity> resourceEntityList;
}

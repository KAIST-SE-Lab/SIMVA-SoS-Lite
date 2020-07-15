package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;

import java.util.ArrayList;

abstract public class Infrastructure extends _SimObject_ {

    EnumInfraType infraType;

    ArrayList<SystemEntity> systemEntityList;
    ArrayList<ServiceEntity> serviceEntityList;
    ArrayList<ResourceEntity> resourceEntityList;
}

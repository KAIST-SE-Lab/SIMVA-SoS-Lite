package kr.ac.kaist.se.model.strc;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.behv.Role;
import kr.ac.kaist.se.model.behv.Task;

import java.util.ArrayList;

abstract public class Organization extends _SimObject_ {

    EnumOrgType orgType;

    ArrayList<Organization> subOrgList; //Suborganizations
    ArrayList<CS> csList;               //Member CSs
    ArrayList<Task> taskList;           //List of all tasks included in this org
    ArrayList<Role> roleList;           //List of all roles included in this org
}

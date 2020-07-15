package kr.ac.kaist.se.model.behv;

import kr.ac.kaist.se.model.abst.cap._SimAction_;
import kr.ac.kaist.se.model.abst.sys._SimNonActionableObject_;
import kr.ac.kaist.se.model.strc.CS;

import java.util.ArrayList;

abstract public class Role extends _SimNonActionableObject_ {

    //Already defined in _SimObject_
//    String roleId;
//    String roleName;

    ArrayList<_SimAction_> reqActions;  //List of required actions

    ArrayList<CS> assignedCSs;          //CSs who play this role
}

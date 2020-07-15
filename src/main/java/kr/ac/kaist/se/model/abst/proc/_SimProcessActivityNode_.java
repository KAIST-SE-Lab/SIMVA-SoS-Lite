package kr.ac.kaist.se.model.abst.proc;

import kr.ac.kaist.se.model.behv.Role;
import kr.ac.kaist.se.model.strc.ResourceEntity;

import java.util.ArrayList;

abstract public class _SimProcessActivityNode_ extends _SimProcessNode_{

    EnumActivityType activityType;

    ArrayList<Role> reqRoles;
    ArrayList<ResourceEntity> reqResources;
}

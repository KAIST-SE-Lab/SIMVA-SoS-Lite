package kr.ac.kaist.se.model.behv;

import kr.ac.kaist.se.model.abst.proc._SimProcess_;

import java.util.ArrayList;

abstract public class Task extends _SimProcess_ {

    protected ArrayList<Task> subTaskList;
    protected ArrayList<Role> roleList;

}

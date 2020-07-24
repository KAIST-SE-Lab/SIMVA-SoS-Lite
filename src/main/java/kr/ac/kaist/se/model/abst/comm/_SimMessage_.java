package kr.ac.kaist.se.model.abst.comm;

import kr.ac.kaist.se.intf.Transmittable;
import kr.ac.kaist.se.model.abst.data._SimData_;

import java.util.ArrayList;

abstract public class _SimMessage_ implements Transmittable {
    protected String msgId;

    //TODO: other properties of a message
    protected String msgTag; //or EnumMsgTag

    protected EnumMsgType msgType;

    //TODO: properties for communication
    protected String senderId;
    protected String receiverId;

    protected ArrayList<_SimData_> dataList;
}

package kr.ac.kaist.se.model.abst.comm;

import kr.ac.kaist.se.intf.Sendable;
import kr.ac.kaist.se.model.abst.data._SimData_;

import java.util.ArrayList;

abstract public class _SimMessage_ implements Sendable {
    String msgId;

    //TODO: other properties of a message
    String msgTag; //or EnumMsgTag

    EnumMsgType msgType;

    //TODO: properties for communication
    String senderId;
    String receiverId;

    ArrayList<_SimData_> dataList;
}

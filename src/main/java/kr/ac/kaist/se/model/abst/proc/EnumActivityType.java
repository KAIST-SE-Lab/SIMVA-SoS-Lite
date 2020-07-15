package kr.ac.kaist.se.model.abst.proc;

public enum EnumActivityType {

    //This types are based on the UML Activity Diagram

    GENERAL,
    CREATE_OR_GENERATE,
    DESTROY_OR_DELETE,
    READ,
    WRITE,
    SEND_SIGNAL,
    ACCEPT_SIGNAL,
    TRIGGER_EVENT,
    ACCEPT_EVENT,
    TIME_EVENT
}

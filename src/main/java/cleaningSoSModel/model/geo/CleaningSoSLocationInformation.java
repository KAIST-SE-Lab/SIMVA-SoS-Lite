package cleaningSoSModel.model.geo;

import kr.ac.kaist.se.model.abst.sys._SimObject_;
import kr.ac.kaist.se.model.geo.LocationInformation;

import java.util.ArrayList;

public class CleaningSoSLocationInformation extends LocationInformation {
    private boolean isWall;
    private boolean isCleaningTarget;
    private boolean isChargingStation;
    private String roomID;

    public CleaningSoSLocationInformation(ArrayList<_SimObject_> objectArrayList, boolean wall, boolean cleaningTarget, boolean chargingStation, String room){
        super(objectArrayList);
        this.isWall = wall;
        this.isCleaningTarget = cleaningTarget;
        this.isChargingStation = chargingStation;
        this.roomID = room;
    }

    public boolean isWall() {
        return isWall;
    }

    public boolean isCleaningTarget() {
        return isCleaningTarget;
    }

    public boolean isChargingStation() {
        return isChargingStation;
    }

    public String getRoomID() {
        return roomID;
    }
}
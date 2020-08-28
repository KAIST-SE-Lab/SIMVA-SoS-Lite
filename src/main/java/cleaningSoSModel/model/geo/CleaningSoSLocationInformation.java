package cleaningSoSModel.model.geo;

import kr.ac.kaist.se.model.geo.LocationInformation;

public class CleaningSoSLocationInformation extends LocationInformation {
    private boolean wallOrNot;
    private boolean isCleaningTarget;
    private boolean isChargingStation;
    private String roomID;

    public CleaningSoSLocationInformation(boolean wall, boolean cleaningTarget, boolean chargingStation, String room){
        this.wallOrNot = wall;
        this.isCleaningTarget = cleaningTarget;
        this.isChargingStation = chargingStation;
        this.roomID = room;
    }

    public boolean isWallOrNot() {
        return wallOrNot;
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
package cleaningSoSModel.model.geo;

import kr.ac.kaist.se.model.geo.LocationInformation;
import kr.ac.kaist.se.model.geo.Map;
import kr.ac.kaist.se.model.geo.ObjectLocation;

public class CleaningSoSMap extends Map {
    private int minX = 0;
    private int maxX = 2;
    private int minY = 0;
    private int maxY = 2;

    @Override
    public boolean isValidLocation(ObjectLocation loc) {
        CleaningSoSObjectLocation curLoc = (CleaningSoSObjectLocation)loc;
        if(curLoc.getX() >= minX && curLoc.getX() <= maxX){
            if(curLoc.getY() >= minY && curLoc.getY() <= maxY){
                if(curLoc.getFloor() != null){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public LocationInformation getLocationInfo(ObjectLocation loc) {
        if(isValidLocation(loc)){
            CleaningSoSObjectLocation curLoc = (CleaningSoSObjectLocation)loc;
            boolean wallOrNot;
            boolean isCleaningTarget;
            boolean isChargingStation;
            String roomID;

            if(curLoc.getFloor() == Floor.UNDERGROUND){
                wallOrNot = false;
                isCleaningTarget = false;
                isChargingStation = false;
                roomID = "C";
            }
            else{
                if(curLoc.getX() == 1 && curLoc.getY() == 1){
                    wallOrNot = true;
                }
                else{
                    wallOrNot = false;
                }

                isCleaningTarget = true;

                if(curLoc.getX() == 2 && curLoc.getY() == 1){
                    isChargingStation = true;
                }
                else{
                    isChargingStation = false;
                }

                if(curLoc.getX() == 0){
                    roomID = "A";
                }
                else{
                    roomID = "B";
                }
            }
            return new CleaningSoSLocationInformation(this.getLocationArrayList(loc), wallOrNot, isCleaningTarget, isChargingStation, roomID);
        }
        else{
            return null;
        }
    }
}
package cleaningSoSModel.model.geo;

import kr.ac.kaist.se.model.geo.ObjectLocation;

public class CleaningSoSObjectLocation extends ObjectLocation {
    private int x;
    private int y;
    private Floor floor;

    public CleaningSoSObjectLocation(int x, int y, Floor f){
        this.x = x;
        this.y = y;
        this.floor = f;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public boolean isSameLocation(ObjectLocation target){
        if(!(target instanceof CleaningSoSObjectLocation)){
            return false;
        }

        CleaningSoSObjectLocation cleaningSoSObjectLocation = (CleaningSoSObjectLocation) target;

        if(this.x != cleaningSoSObjectLocation.getX()){
            return false;
        }

        if(this.y != cleaningSoSObjectLocation.getY()){
            return false;
        }

        if(this.floor != cleaningSoSObjectLocation.getFloor()){
            return false;
        }

        return true;
    }
}
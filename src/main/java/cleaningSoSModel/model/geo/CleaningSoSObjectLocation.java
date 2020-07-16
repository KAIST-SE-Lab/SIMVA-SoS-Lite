package cleaningSoSModel.model.geo;

import kr.ac.kaist.se.model.geo.ObjectLocation;

public class CleaningSoSObjectLocation extends ObjectLocation {
    private int x;
    private int y;

    public CleaningSoSObjectLocation(int x, int y){
        this.x = x;
        this.y = y;
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
}
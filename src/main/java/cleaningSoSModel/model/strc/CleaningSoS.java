package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.geo.CleaningSoSMap;
import kr.ac.kaist.se.model.strc.SoS;

public class CleaningSoS extends SoS {
    public CleaningSoS(String name){
        super(name);
        this.map = new CleaningSoSMap();
    }
}

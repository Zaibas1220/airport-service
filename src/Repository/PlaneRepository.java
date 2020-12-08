package Repository;

import Entity.Plane;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaneRepository {
    HashMap<String, Plane> planes;

    public PlaneRepository() {
        this.planes = new HashMap<>();
    }

    public void add (Plane plane){
        planes.put(plane.getID(),plane);
    }

    public void remove (String planeID){
        planes.remove(planeID);
    }

    public ArrayList<Plane> index (){
        return new ArrayList(planes.values());
    }

    public Plane view (String planeID) {
        return planes.get(planeID);
    }

    public void edit (String planeID, Plane plane){
        if (view(planeID) == null){
            return;
        }
        add(plane);
    }
}

package Entity;

public class Plane {

    private String ID;
    private Integer planeCapacity;

    public Plane(String ID, Integer planeCapacity) {
        this.ID = ID;
        this.planeCapacity = planeCapacity;
    }

    public String getID() {
        return ID;
    }

    public Integer getCapacity() {
        return planeCapacity;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPlaneCapacity(Integer planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

}

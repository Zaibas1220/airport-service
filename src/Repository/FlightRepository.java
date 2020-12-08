package Repository;

import Entity.Flight;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightRepository {
    private ArrayList<Flight> flights;

    public FlightRepository (){
        this.flights = new ArrayList<>();
    }

    public void add (Flight flight){
        flights.add(flight);
    }

    public void remove (int flightID){
        if ( flightID > flights.size() || flightID < 0 ){
            return;
        }
        flights.remove(flightID);
    }

    public ArrayList<Flight> index() {
        return flights;
    }

    public Flight view (int flightID){
        if ( flightID > flights.size() || flightID < 0 ){
            return null;
        }
        return flights.get(flightID);
    }

    public void edit (int flightID, Flight flight){
        if ( flightID > flights.size() || flightID < 0 ){
            return;
        }
        flights.set(flightID, flight);
    }
}

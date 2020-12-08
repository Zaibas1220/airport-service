package Controller;

import Entity.Flight;
import Entity.Plane;
import Repository.FlightRepository;
import Repository.PlaneRepository;

import java.util.Scanner;

public class FlightServiceController {
    private Scanner reader;
    private PlaneRepository planeRepository;
    private FlightRepository flightRepository;

    public FlightServiceController(Scanner reader, PlaneRepository planes, FlightRepository flightRepository) {
        this.reader = reader;
        this.planeRepository = planes;
        this.flightRepository = flightRepository;
    }

    public void run (){
        System.out.println("Flight Service\n" + "_____________________\n");
        while (true) {

            System.out.print("Choose operation\n" + "[1] Print planes\n" + "[2] Print flights\n" + "[3] Print plane info\n" + "[X] Exit\n");
            switch (reader.nextLine().toLowerCase()) {
                case ("1"):
                    printPlanes();
                    break;
                case ("2"):
                    printFlight();
                    break;
                case ("3"):
                    printPlaneInfo();
                    break;
                case ("x"):
                    return;
                default:
                    System.out.println("Unknown Command.\n");
            }
        }
    }

    public void printPlanes (){
        for (Plane plane : planeRepository.index()){
            System.out.println(plane.getID() + "(" + plane.getCapacity() + " ppl)\n");
        }
    }

    public void printFlight (){
        for (Flight flight : flightRepository.index()){
            System.out.println(flight.getPlane().getID() + "(" + flight.getPlane().getCapacity()
                    + " ppl) (" + flight.getDeparture() + "-" + flight.getDestination() + ")\n");
        }
    }

    public void printPlaneInfo (){
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();

        if (planeRepository.view(planeID)==null){
            System.out.println("Unknown ID.\n");
            return;
        }

        System.out.println(planeID + "(" + planeRepository.view(planeID).getCapacity() + " ppl)\n");
    }
}

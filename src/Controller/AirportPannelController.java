package Controller;

import Entity.Flight;
import Entity.Plane;
import Repository.FlightRepository;
import Repository.PlaneRepository;

import java.util.Scanner;

public class AirportPannelController {
    private Scanner reader;
    private PlaneRepository planeRepository;
    private FlightRepository flights;

    public AirportPannelController (Scanner reader, PlaneRepository planeRepository, FlightRepository flights){
        this.reader = reader;
        this.planeRepository = planeRepository;
        this.flights = flights;
    }

    public void run (){
        System.out.println("Airport Pannel\n" + "_______________________");
        while (true) {

            System.out.print("Choose operation\n" + "[1] Add airplane\n" + "[2] Add flight\n" + "[X] Exit\n");
            switch (reader.nextLine().toLowerCase()) {
                case ("1"):
                    addPlane();
                    break;
                case ("2"):
                    addFlight();
                    break;
                case ("x"):
                    return;
                default:
                    System.out.println("Unknown Command.\n");
            }
        }
    }

    public void addPlane() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        Integer planeCapacity = Integer.parseInt(reader.nextLine());
        Plane plane = new Plane(planeID, planeCapacity);
        planeRepository.add(plane);
        System.out.println("\n");
    }

    public void addFlight() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        if (planeRepository.view(planeID)==null){
            System.out.println("Unknown ID.\n");
            return;
        }
        System.out.print("Give departure airport code: ");
        String departure = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = reader.nextLine();

        Flight flight = new Flight(planeRepository.view(planeID), departure, destination);
        flights.add(flight);

        System.out.println("\n");
    }
}

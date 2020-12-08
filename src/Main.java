import Controller.AirportPannelController;
import Controller.FlightServiceController;
import Entity.Plane;
import Repository.FlightRepository;
import Repository.PlaneRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String answers = "1\n" + "AC130\n" + "125\n" + "1\n" + "Boing747\n" + "275\n" + "2\n" + "Boing747\n" + "LON\n" +
                "DUB\n" + "2\n" + "AC130\n" + "NAP\n" + "PRG\n" + "2\n" + "ABC123\n" + "3\n" + "x\n" + "1\n" + "2\n" + "3\n" + "Boing747\n" + "3\n" +
                "ABC123\n" + "4\n" + "x\n";

        Scanner reader = new Scanner(answers);

        PlaneRepository planeRepository = new PlaneRepository();
        FlightRepository flightRepository = new FlightRepository();

        AirportPannelController airportPannelController = new AirportPannelController(reader, planeRepository, flightRepository);

        airportPannelController.run();

        FlightServiceController flightServiceController = new FlightServiceController(reader, planeRepository, flightRepository);

        flightServiceController.run();
    }
}

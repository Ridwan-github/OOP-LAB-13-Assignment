import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Flight extends FlightDistance {

    private final String flightSchedule;
    private final String flightNumber;
    private final String fromWhichCity;
    private final String gate;
    private final String toWhichCity;
    private double distanceInMiles;
    private double distanceInKm;
    private String flightTime;
    private int numOfSeatsInTheFlight;
    private List<Customer> listOfRegisteredCustomersInAFlight;

    private static final List<Flight> flightList = new ArrayList<>();

    public Flight(String flightSchedule, String flightNumber, int numOfSeatsInTheFlight, String[][] chosenDestinations, String[] distanceBetweenTheCities, String gate) {
        this.flightSchedule = flightSchedule;
        this.flightNumber = flightNumber;
        this.numOfSeatsInTheFlight = numOfSeatsInTheFlight;
        this.fromWhichCity = chosenDestinations[0][0];
        this.toWhichCity = chosenDestinations[0][1];
        this.gate = gate;
        this.distanceInMiles = Double.parseDouble(distanceBetweenTheCities[0]);
        this.distanceInKm = Double.parseDouble(distanceBetweenTheCities[1]);
        this.listOfRegisteredCustomersInAFlight = new ArrayList<>();
    }

    public String getFlightSchedule() { return flightSchedule; }
    public String getFlightNumber() { return flightNumber; }
    public String getFromWhichCity() { return fromWhichCity; }
    public String getToWhichCity() { return toWhichCity; }
    public String getGate() { return gate; }
    public int getNumOfSeats() { return numOfSeatsInTheFlight; }
    public List<Customer> getRegisteredCustomers() { return Collections.unmodifiableList(listOfRegisteredCustomersInAFlight); }
    public static List<Flight> getFlightList() { return Collections.unmodifiableList(flightList); }

    public void addCustomerToFlight(Customer customer) {
        if (!listOfRegisteredCustomersInAFlight.contains(customer)) {
            listOfRegisteredCustomersInAFlight.add(customer);
        }
    }

    public void updateSeatCount(int seatsBooked) {
        this.numOfSeatsInTheFlight -= seatsBooked;
    }

    public void displayFlightSchedule() {
        System.out.println("Flight Schedule: " + flightSchedule);
    }

    @Override
    public String toString(int i) {
        return "";
    }

    @Override
    public String[] calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return new String[0];
    }
}
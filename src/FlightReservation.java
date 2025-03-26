public class FlightReservation implements DisplayClass {

    Flight flight = new Flight();

    void bookFlight(String flightNo, int numOfTickets, String userID) {
        Flight selectedFlight = findFlightByNumber(flightNo);
        if (selectedFlight == null) {
            System.out.println("Flight not found.");
            return;
        }

        Customer customer = findCustomerById(userID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        updateSeats(selectedFlight, numOfTickets);
        manageCustomerFlightRegistration(selectedFlight, customer, numOfTickets);
    }

    private Flight findFlightByNumber(String flightNo) {
        for (Flight f : flight.getFlightList()) {
            if (flightNo.equalsIgnoreCase(f.getFlightNumber())) {
                return f;
            }
        }
        return null;
    }

    private Customer findCustomerById(String userID) {
        for (Customer customer : Customer.getCustomerCollection()) {
            if (userID.equals(customer.getUserID())) {
                return customer;
            }
        }
        return null;
    }

    private void updateSeats(Flight flight, int numOfTickets) {
        flight.updateSeatCount(numOfTickets);
    }

    private void manageCustomerFlightRegistration(Flight flight, Customer customer, int numOfTickets) {
        flight.addCustomerToFlight(customer);
        customer.addFlight(flight, numOfTickets);
    }

    public void cancelFlight(String flightNo, String userID) {
        Flight selectedFlight = findFlightByNumber(flightNo);
        if (selectedFlight == null) {
            System.out.println("Flight not found.");
            return;
        }

        Customer customer = findCustomerById(userID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        updateSeats(selectedFlight, -customer.getTicketsBookedForFlight(selectedFlight));
        manageCustomerFlightCancellation(selectedFlight, customer);

    }
}

import java.util.*;

public class User {
    // Fields
    static String[][] adminUserNameAndPassword = new String[10][2];
    private static List<Customer> customersCollection = new ArrayList<>();

    // Main method
    public static void main(String[] args) {
        int countNumOfUsers = 1;
        RolesAndPermissions r1 = new RolesAndPermissions();
        Flight f1 = new Flight();
        FlightReservation bookingAndReserving = new FlightReservation();
        Customer c1 = new Customer(); // Using no-argument constructor
        f1.flightSchedule();
        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);

        displayMainMenu();
        int desiredOption = read1.nextInt();
        while (desiredOption < 0 || desiredOption > 8) {
            System.out.print("ERROR!! Please enter value between 0 - 4. Enter the value again :\t");
            desiredOption = read1.nextInt();
        }

        do {
            if (desiredOption == 3) {
                System.out.print("Enter username: ");
                String userName = read.next();
                System.out.print("Enter password: ");
                String password = read.next();
                String[] result = login(userName, password);

                if (result != null) {
                    int desiredChoice;
                    do {
                        displayUserMenu();
                        desiredChoice = read.nextInt();
                        if (desiredChoice == 1) {
                            System.out.print("Enter flight number to book: ");
                            String flightToBeBooked = read.next();
                            System.out.print("Enter number of tickets: ");
                            int numOfTickets = read.nextInt();
                            bookingAndReserving.bookFlight(flightToBeBooked, numOfTickets, result[1]);
                        } else if (desiredChoice == 2) {
                            c1.editUserInfo(result[1]);
                        } else if (desiredChoice == 3) {
                            System.out.print("Are you sure to delete your account...It's an irreversible action...Enter Y/y to confirm...");
                            char confirmationChar = read1.nextLine().charAt(0);
                            if (confirmationChar == 'Y' || confirmationChar == 'y') {
                                c1.deleteUser(result[1]);
                                System.out.printf("User %s's account deleted Successfully...!!!", userName);
                                desiredChoice = 0;
                            } else {
                                System.out.println("Action has been cancelled...");
                            }
                        } else if (desiredChoice == 4) {
                            f1.displayFlightSchedule();
                            f1.displayMeasurementInstructions();
                        } else if (desiredChoice == 5) {
                            bookingAndReserving.cancelFlight(result[1]);
                        } else if (desiredChoice == 6) {
                            bookingAndReserving.displayFlightsRegisteredByOneUser(result[1]);
                        } else {
                            if (desiredChoice != 0) {
                                System.out.println("Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");
                            }
                            desiredChoice = 0;
                        }
                    } while (desiredChoice != 0);
                } else {
                    System.out.printf("\n%20sERROR!!! Unable to login Cannot find user with the entered credentials.... Try Creating New Credentials or get yourself register by pressing 4....\n", "");
                }
            } else if (desiredOption == 4) {
                c1.addNewCustomer();
            } else if (desiredOption == 5) {
                manualInstructions();
            }

            displayMainMenu();
            desiredOption = read1.nextInt();
            while (desiredOption < 0 || desiredOption > 8) {
                System.out.print("ERROR!! Please enter value between 0 - 4. Enter the value again :\t");
                desiredOption = read1.nextInt();
            }
        } while (desiredOption != 0);
    }

    static void displayMainMenu() {
        System.out.println("\n\n\t\t(a) Press 0 to Exit.");
        System.out.println("\t\t(b) Press 1 to Login as admin.");
        System.out.println("\t\t(c) Press 2 to Register as admin.");
        System.out.println("\t\t(d) Press 3 to Login as Passenger.");
        System.out.println("\t\t(e) Press 4 to Register as Passenger.");
        System.out.println("\t\t(f) Press 5 to Display the User Manual.");
        System.out.print("\t\tEnter the desired option:    ");
    }

    static void displayUserMenu() {
        System.out.println("\n\n\t\t(a) Press 1 to Book a Flight.");
        System.out.println("\t\t(b) Press 2 to Edit User Info.");
        System.out.println("\t\t(c) Press 3 to Delete User.");
        System.out.println("\t\t(d) Press 4 to Display Flight Schedule.");
        System.out.println("\t\t(e) Press 5 to Cancel a Flight.");
        System.out.println("\t\t(f) Press 6 to Display Registered Flights.");
        System.out.print("\t\tEnter the desired option:    ");
    }

    static void manualInstructions() {
        Scanner read = new Scanner(System.in);
        System.out.printf("%n%n%50s %s Welcome to BAV Airlines User Manual %s", "", "+++++++++++++++++", "+++++++++++++++++");
        System.out.println("\n\n\t\t(a) Press 1 to display Admin Manual.");
        System.out.println("\t\t(b) Press 2 to display User Manual.");
        System.out.print("\nEnter the desired option :    ");
        int choice = read.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.print("ERROR!!! Invalid entry...Please enter a value either 1 or 2....Enter again....");
            choice = read.nextInt();
        }
        if (choice == 1) {
            System.out.println("\n\n(1) Admin have the access to all users data...Admin can delete, update, add and can perform search for any customer...\n");
            System.out.println("(2) In order to access the admin module, you've to get yourself register by pressing 2, when the main menu gets displayed...\n");
            System.out.println("(3) Provide the required details i.e., name, email, id...Once you've registered yourself, press 1 to login as an admin... \n");
            System.out.println("(4) Once you've logged in, 2nd layer menu will be displayed on the screen...From here on, you can select from variety of options...\n");
            System.out.println("(5) Pressing \"1\" will add a new Passenger, provide the program with required details to add the passenger...\n");
            System.out.println("(6) Pressing \"2\" will search for any passenger, given the admin(you) provides the ID from the table printing above....  \n");
            System.out.println("(7) Pressing \"3\" will let you update any passengers data given the user ID provided to program...\n");
            System.out.println("(8) Pressing \"4\" will let you delete any passenger given its ID provided...\n");
            System.out.println("(9) Pressing \"5\" will let you display all registered passenger...\n");
            System.out.println("(10) Pressing \"6\" will let you display all registered passengers...After selecting, program will ask, if you want to display passengers for all flights(Y/y) or a specific flight(N/n)\n");
            System.out.println("(11) Pressing \"7\" will let you delete any flight given its flight number provided...\n");
            System.out.println("(11) Pressing \"0\" will make you logged out of the program...You can login again any time you want during the program execution....\n");
        } else {
            System.out.println("\n\n(1) Local user has the access to its data only...He/She won't be able to change/update other users data...\n");
            System.out.println("(2) In order to access local users benefits, you've to get yourself register by pressing 4, when the main menu gets displayed...\n");
            System.out.println("(3) Provide the details asked by the program to add you to the users list...Once you've registered yourself, press \"3\" to login as a passenger...\n");
            System.out.println("(4) Once you've logged in, 3rd layer menu will be displayed...From here on, you embarked on the journey to fly with us...\n");
            System.out.println("(5) Pressing \"1\" will display available/scheduled list of flights...To get yourself booked for a flight, enter the flight number and number of tickets for the flight...Max num of tickets at a time is 10 ...\n");
            System.out.println("(7) Pressing \"2\" will let you update your own data...You won't be able to update other's data... \n");
            System.out.println("(8) Pressing \"3\" will delete your account... \n");
            System.out.println("(9) Pressing \"4\" will display randomly designed flight schedule for this runtime...\n");
            System.out.println("(10) Pressing \"5\" will let you cancel any flight registered by you...\n");
            System.out.println("(11) Pressing \"6\" will display all flights registered by you...\n");
            System.out.println("(12) Pressing \"0\" will make you logout of the program...You can login back at anytime with your credentials...for this particular run-time... \n");
        }
    }

    public static List<Customer> getCustomersCollection() {
        return customersCollection;
    }

    public static String[] login(String userName, String password) {
        // Implement login logic here
        return null;
    }
}
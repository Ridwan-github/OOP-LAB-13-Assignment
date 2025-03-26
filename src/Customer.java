import java.util.*;

public class Customer {
    // Fields
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;

    // No-argument constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String id, String name, String email, String phone, String address, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }

    // Method to display customer data
    public void displayCustomersData(boolean isStandardUser) {
        for (Customer customer : User.getCustomersCollection()) {
            System.out.println("ID: " + customer.id);
            System.out.println("Name: " + customer.name);
            System.out.println("Email: " + customer.email);
            System.out.println("Phone: " + customer.phone);
            System.out.println("Address: " + customer.address);
            System.out.println("Age: " + customer.age);
            if (isStandardUser) {
                System.out.println("Standard User: Limited Access");
            }
            System.out.println("-------------------------------");
        }
    }

    // Method to search for a user
    public void searchUser(String customerID) {
        for (Customer customer : User.getCustomersCollection()) {
            if (customer.id.equals(customerID)) {
                System.out.println("Customer found:");
                System.out.println("ID: " + customer.id);
                System.out.println("Name: " + customer.name);
                System.out.println("Email: " + customer.email);
                System.out.println("Phone: " + customer.phone);
                System.out.println("Address: " + customer.address);
                System.out.println("Age: " + customer.age);
                return;
            }
        }
        System.out.println("Customer with ID " + customerID + " not found.");
    }

    // Method to edit user information
    public void editUserInfo(String customerID) {
        Scanner scanner = new Scanner(System.in);
        for (Customer customer : User.getCustomersCollection()) {
            if (customer.id.equals(customerID)) {
                System.out.println("Editing customer with ID: " + customerID);
                System.out.print("Enter new name: ");
                customer.name = scanner.nextLine();
                System.out.print("Enter new email: ");
                customer.email = scanner.nextLine();
                System.out.print("Enter new phone: ");
                customer.phone = scanner.nextLine();
                System.out.print("Enter new address: ");
                customer.address = scanner.nextLine();
                System.out.print("Enter new age: ");
                customer.age = scanner.nextInt();
                System.out.println("Customer information updated.");
                return;
            }
        }
        System.out.println("Customer with ID " + customerID + " not found.");
    }

    // Method to delete a user
    public void deleteUser(String customerID) {
        Iterator<Customer> iterator = User.getCustomersCollection().iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.id.equals(customerID)) {
                iterator.remove();
                System.out.println("Customer with ID " + customerID + " deleted.");
                return;
            }
        }
        System.out.println("Customer with ID " + customerID + " not found.");
    }
}
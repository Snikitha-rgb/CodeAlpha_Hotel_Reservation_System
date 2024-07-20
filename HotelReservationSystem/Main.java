import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Hotel hotel;

    public static void main(String[] args) {
        hotel = new Hotel();

        
        hotel.addRoom(new Room(101, "Standard", 100.0));
        hotel.addRoom(new Room(102, "Deluxe", 150.0));
        hotel.addRoom(new Room(103, "Suite", 200.0));

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to the Hotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookingDetails(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }

        scanner.close();
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();

        boolean reservationSuccess = hotel.makeReservation(guestName, checkInDate, checkOutDate, roomNumber);
        if (reservationSuccess) {
            
            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();
            hotel.processPayment(hotel.nextBookingId - 1, amount);
        }
    }

    private static void viewBookingDetails(Scanner scanner) {
        System.out.print("Enter booking ID: ");
        int bookingId = scanner.nextInt();
        hotel.displayBookingDetails(bookingId);
    }
}

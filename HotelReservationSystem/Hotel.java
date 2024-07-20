import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings;
    public int nextBookingId;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        nextBookingId = 1; // Starting booking ID
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room number: " + room.getRoomNumber() + ", Category: " + room.getCategory() + ", Price: " + room.getPrice());
            }
        }
    }

    public boolean makeReservation(String guestName, LocalDate checkInDate, LocalDate checkOutDate, int roomNumber) {
        // Find the room
        Room bookedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                bookedRoom = room;
                break;
            }
        }

        if (bookedRoom == null) {
            System.out.println("Room " + roomNumber + " is not available.");
            return false;
        }

        // Create booking
        Booking booking = new Booking(nextBookingId++, guestName, checkInDate, checkOutDate, bookedRoom);
        bookings.add(booking);

        // Mark room as unavailable
        bookedRoom.setAvailable(false);

        System.out.println("Reservation successful. Booking ID: " + booking.getBookingId());
        return true;
    }

    public void displayBookingDetails(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Guest Name: " + booking.getGuestName());
                System.out.println("Check-in Date: " + booking.getCheckInDate());
                System.out.println("Check-out Date: " + booking.getCheckOutDate());
                System.out.println("Room Number: " + booking.getBookedRoom().getRoomNumber());
                System.out.println("Room Category: " + booking.getBookedRoom().getCategory());
                System.out.println("Total Price: " + booking.getBookedRoom().getPrice()); 
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }

    
    public boolean processPayment(int bookingId, double amount) {
        System.out.println("Payment of $" + amount + " for booking ID " + bookingId + " processed successfully.");
        return true;
    }
}

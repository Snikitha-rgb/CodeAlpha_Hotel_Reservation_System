import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Room bookedRoom;

    public Booking(int bookingId, String guestName, LocalDate checkInDate, LocalDate checkOutDate, Room bookedRoom) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookedRoom = bookedRoom;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getGuestName() {
        return guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }
}

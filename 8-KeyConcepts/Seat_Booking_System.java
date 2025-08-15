import java.util.*;

// Enum for booking type
enum BookingType {
    NORMAL,
    VIP
}

// Class for Seat
class Seat {
    public int seatNumber;
    public boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}

// Class for Booking
class Booking {
    public String customerName;
    public BookingType bookingType;
    public Seat seat;

    public Booking(String customerName, BookingType bookingType, Seat seat) {
        this.customerName = customerName;
        this.bookingType = bookingType;
        this.seat = seat;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public Seat getSeat() {
        return seat;
    }
}

// Class for TicketBookingSystem
class TicketBookingSystem {
    public List<Seat> seats;
    public List<Booking> bookings;

    public TicketBookingSystem(int totalSeats) {
        this.seats = new ArrayList<>();
        this.bookings = new ArrayList<>();

        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    // Method to book a seat
    public synchronized boolean bookSeat(Booking booking) {
        Seat seat = booking.getSeat();
        if (seat.isBooked()) {
            return false; // Seat is already booked
        }

        seat.setBooked(true);
        bookings.add(booking);
        System.out.println("Seat " + seat.getSeatNumber() + " booked for " + booking.getCustomerName() + " (" + booking.getBookingType() + ")");
        return true;
    }

    // Method to display bookings
    public void displayBookings() {
        System.out.println("Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Customer: " + booking.getCustomerName() + ", Seat: " + booking.getSeat().getSeatNumber() + ", Type: " + booking.getBookingType());
        }
    }
}

// Class for BookingThread
class BookingThread extends Thread {
    private TicketBookingSystem system;
    private Booking booking;

    public BookingThread(TicketBookingSystem system, Booking booking) {
        this.system = system;
        this.booking = booking;

        // Set thread priority based on booking type
        if (booking.getBookingType() == BookingType.VIP) {
            setPriority(Thread.MAX_PRIORITY);
        } else {
            setPriority(Thread.NORM_PRIORITY);
        }
    }

    @Override
    public void run() {
        if (system.bookSeat(booking)) {
            System.out.println("Booking successful for " + booking.getCustomerName());
        } else {
            System.out.println("Booking failed for " + booking.getCustomerName() + ". Seat is already booked.");
        }
    }
}

public class Seat_Booking_System {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10);

        // Create bookings
        Booking booking1 = new Booking("John Doe", BookingType.NORMAL, system.seats.get(0));
        Booking booking2 = new Booking("Jane Doe", BookingType.VIP, system.seats.get(0)); // Same seat as booking1
        Booking booking3 = new Booking("Bob Smith", BookingType.NORMAL, system.seats.get(1));
        Booking booking4 = new Booking("Alice Johnson", BookingType.VIP, system.seats.get(2));

        // Create and start booking threads
        BookingThread thread1 = new BookingThread(system, booking1);
        BookingThread thread2 = new BookingThread(system, booking2);
        BookingThread thread3 = new BookingThread(system, booking3);
        BookingThread thread4 = new BookingThread(system, booking4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Display bookings
        system.displayBookings();
    }
}

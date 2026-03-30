import java.util.*;

public class Main {
    public static void main(String[] args) {
        CinemaManagementService cinemaService = new CinemaManagementService();
        BookingService reservationService = new BookingService();

        List<Seat> seats = Arrays.asList(
            new Seat("A1", SeatType.GOLD, 200.0),
            new Seat("A2", SeatType.GOLD, 200.0)
        );

        Show show = new Show("S1", "Inception", "PVR_01", seats);
        cinemaService.addShow(show);

        List<String> chosenSeats = Arrays.asList("A1", "A2");
        PaymentMethod upiPayment = new UPIPayment();

        boolean success = reservationService.createReservation(show, chosenSeats, upiPayment);
        System.out.println("Reservation successful: " + success);
    }
}
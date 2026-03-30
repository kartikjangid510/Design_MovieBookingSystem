import java.util.*;

public class BookingService {
    public boolean createReservation(Show show, List<String> seatCodes, PaymentMethod paymentMethod) {
        if (show.reserveSeats(seatCodes)) {
            double totalAmount = computeTotal(show, seatCodes);
            if (paymentMethod.processPayment(totalAmount)) {
                return true;
            } else {
                show.releaseSeats(seatCodes);
                return false;
            }
        }
        return false;
    }

    private double computeTotal(Show show, List<String> seatCodes) {
        return show.getAllSeats().stream()
                .filter(s -> seatCodes.contains(s.getCode()))
                .mapToDouble(s -> s.getCost())
                .sum();
    }
}
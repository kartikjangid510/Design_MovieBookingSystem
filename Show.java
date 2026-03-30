import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
    private String id;
    private String title;
    private String venueId;
    private Map<String, Boolean> seatAvailability; 
    private List<Seat> seats;

    public Show(String id, String title, String venueId, List<Seat> seats) {
        this.id = id;
        this.title = title;
        this.venueId = venueId;
        this.seats = seats;
        this.seatAvailability = new ConcurrentHashMap<>();
        for (Seat seat : seats) {
            seatAvailability.put(seat.getCode(), true);
        }
    }

    public synchronized boolean reserveSeats(List<String> seatCodes) {
        for (String code : seatCodes) {
            if (!seatAvailability.getOrDefault(code, false)) return false;
        }
        for (String code : seatCodes) {
            seatAvailability.put(code, false);
        }
        return true;
    }

    public synchronized void releaseSeats(List<String> seatCodes) {
        for (String code : seatCodes) {
            seatAvailability.put(code, true);
        }
    }

    public List<Seat> getAllSeats() { return seats; }
    public String getTitle() { return title; }
    public Map<String, Boolean> getSeatAvailability() { return seatAvailability; }
}
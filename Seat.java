public class Seat {
    private String code;
    private SeatType seatType;
    private double cost;

    public Seat(String code, SeatType seatType, double cost) {
        this.code = code;
        this.seatType = seatType;
        this.cost = cost;
    }

    public String getCode() { return code; }
    public double getCost() { return cost; }
}
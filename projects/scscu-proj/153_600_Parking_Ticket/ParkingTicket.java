public class ParkingTicket {
    private ParkedCar car;
    private PoliceOfficer officer;
    private double fine;
    private int minutes;
    private final double BASE_FINE = 25.0;
    private final double HOURLY_FINE = 10.0;
    
    public ParkingTicket(ParkedCar car, PoliceOfficer officer, int minutes) {
        this.car = car;
        this.officer = officer;
        this.minutes = minutes;
    }
    
    public ParkingTicket(ParkingTicket ticket2) {
        car = ticket2.car;
        officer = ticket2.officer;
        minutes = ticket2.minutes;
    }
    
    public void calculateFine() {
        fine = this.minutes * HOURLY_FINE + BASE_FINE;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    public String toString() {
        if (fine <= 0)
            return null;
        else
            return "The fine is " + fine + ".";
    }
}
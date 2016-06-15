/**
* Parking Ticket Simulator program
*/

public class ParkingTicketSimulator
{
    public static void main(String[] args) {
        // Create a ParkedCar object. The car was parked for 125 minutes.
        ParkedCar car = new ParkedCar("Porsche", "2010", "Red", "123ABC", 125);
        
        // Create a ParkingMeter object. The driver purchased 60 minutes.
        ParkingMeter meter1 = new ParkingMeter(60);
        
        // Create a PoliceOfficer object
        PoliceOfficer officer = new PoliceOfficer("Chris Rosa", "4788");
        
        // Let the officer patrol.
        ParkingTicket ticket = new ParkingTicket(car, officer, car.getMinutesParked() - meter1.getMinutesPurchased());
        System.out.println(ticket);
        System.out.println(ticket.getMinutes());
        
        
        System.out.println(car.getMinutesParked() - meter1.getMinutesPurchased());
        
        // Create a ParkedCar object, parked for 125 minutes.
        ParkedCar car2 = new ParkedCar("Mustang", "2011", "Black", "123ABC", 30);
        
        // Create a ParkingMeter object. 60 minutes were purchased.
        ParkingMeter meter2 = new ParkingMeter(60);
        
        //???   ticket issued ???
        ParkingTicket ticket2 = officer.patrol(car2, meter2);
        
        if (ticket2 != null)
            System.out.println(ticket);
        else
            System.out.println("No ticket issued!");
      
    }
}
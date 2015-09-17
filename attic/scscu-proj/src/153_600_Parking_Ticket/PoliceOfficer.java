public class PoliceOfficer
{
    private String name;
    private String badgeNum;
    
    public PoliceOfficer(String nm, String bnum)
    {
        name = nm;
        badgeNum = bnum;
    }
    
    public PoliceOfficer (PoliceOfficer officer2)
    {
        name = officer2.name;
        badgeNum = officer2.badgeNum;
    }
    
    public ParkingTicket patrol (ParkedCar car, ParkingMeter meter)
    {
        ParkingTicket ticket = null;
        if (car.getMinutesParked() > meter.getMinutesPurchased())
                ticket = new ParkingTicket(car, this, car.getMinutesParked());
        return ticket;
        
    }
    
    public void setName(String nm)
    {
        name = nm;
    }
    
    public void setBadgeNum(String bnum)
    {
        badgeNum = bnum;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getBadgeNum()
    {
        return badgeNum;
    }
    
    public String toString()
    {
        return "Officer " + name + ", badge number " + badgeNum;
    }
}

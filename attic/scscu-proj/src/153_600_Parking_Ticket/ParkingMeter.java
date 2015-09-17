public class ParkingMeter
{
    private int minPurchased;
        
    public ParkingMeter(int m) 
    {
        minPurchased = m;    
    }
      
    public void setMinutesPurchase(int m)
    {
        minPurchased = m;
    }
      
    public int getMinutesPurchased()
    {
        return minPurchased;
    }
}
public class ParkedCar
{
    private String make, model, color, license;
    private int minutesParked;
    
    // constructor 1
    public ParkedCar(String mk, String mod, String col, String lic, int min)
    {
        make = mk;
        model = mod;
        color = col;
        license = lic;
        minutesParked = min;
    }
    
    // copy constructor
    public ParkedCar(ParkedCar car2)
    {
        make = car2.make;
        model = car2.model;
        color = car2.color;
        license = car2.license;
        minutesParked = car2.minutesParked;
    }
    
    public void setMake(String mk) {
        make = mk;
    }
    
    public void setModel(String mod) {
        model = mod;
    }
    
    public void setColor(String col) {
        color = col;
    }
    
    public void setLicense(String lic) {
        license = lic;
    }
    
    public void setMinutesParked(int min) {
        minutesParked = min;
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getLicense() {
        return license;
    }
    
    public int getMinutesParked() {
        return minutesParked;
    }
    
    // class's default value
    public String toString() {
        return "The parked car is a " + color + " " + make + " " + model + ", license " + license + 
        ". The car has been parked for " + minutesParked + " minutes.";
    }
}
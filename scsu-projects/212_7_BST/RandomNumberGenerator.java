import java.util.Random;

public class RandomNumberGenerator
{
    private int seed;
    private int lowRange, highRange;
    private Random rnd;
    
    RandomNumberGenerator(int argSeed, int argLowRange, int argHighRange)
    {
        seed      = argSeed;
        lowRange  = argLowRange;
        highRange = argHighRange;
        rnd       = new Random();
        
        rnd.setSeed(seed);
    }
    
    public RandomNumberGenerator()
    {
        seed      = 10;
        lowRange  = 0;
        highRange = 500000;
        rnd       = new Random();
        
        rnd.setSeed(seed);
    }
    
    public int getRandomNumber()
    {
        int range = (highRange -lowRange);
        int d     = lowRange + rnd.nextInt(range);
        
        return d;
    }
}

/** Converts fahrenheitenheit to Celsius
  * @param fahrenheit fahrenheitenheit
  * @param cels Celsius
  */

public class ReturnCelsius
{
    public static void main(String[] args)
    {
      double fahrenheit;
      double celsius;
      
      // print table header
      System.out.printf("%12s %12s\n", "Fahrenheit", "Celsius");
      
      // print table data
      for (fahrenheit = 0; fahrenheit < 21; fahrenheit++)
      {
        celsius = celsiusConverter(fahrenheit);
        System.out.printf("%12.2f %12.2f\n", fahrenheit, celsius);
      }
    }
    
    /* This method is refrenced from a static context,
       i.e., without first creating an object.                */
    public static double celsiusConverter(double fahr)
    {
      return (double)5 / 9 * (fahr - 32);
    }
}
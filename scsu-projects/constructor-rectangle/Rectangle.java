public class Rectangle
{
   private double length;
   private double width;

   /**
      Constructor
      @param len The length of a rectangle.
      @param w The width of a rectangle.
   */

   public Rectangle(double len, double w)
   {
      length = len;
      width = w;
   }

   /**
      The setLength method stores a value in the length field.
      @param len The value to store in length.
   */

   public void setLength(double len)
   {
      this.length = len;
      // this doesn't need the "this" -- when is "this" useful?
   }

   /**
      The setWidth method stores a value in the width field.
      @param w The value to store in width.
   */

   public void setWidth(double w)
   {
      width = w;
   }

   /**
      The getLength method returns a rectangle's length.
      @return The value in the length field.
   */

   public double getLength()
   {
      return length;
   }

   /**
      The getWidth method returns a rectangle's width.
      @return The value in the width field.
   */
   
   public double getWidth()
   {
      return width;
   }

   /**
      The getArea method returns a rectangle's area.
      @return The product of length times width.
   */

   public double getArea()
   {
      return length * width;
   }
}
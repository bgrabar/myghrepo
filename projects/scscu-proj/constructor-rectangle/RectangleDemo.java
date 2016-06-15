/**
   Program to create a Rectangle object from the Rectangle class
*/

public class RectangleDemo
{
   public static void main(String[] args)
   {


      double a = 5.0;
      double b = 19.0;
      


	  Rectangle box = new Rectangle(a, b);
      
      System.out.println("The box's length is " + box.getLength());
      
      System.out.println("The box's width is " + box.getWidth());
      
      System.out.println("The box's area is " + box.getArea());
      
      
      
      box.setLength(30.0);
      
      System.out.println("The box's length is " + box.getLength());

      
      
      
   }
}
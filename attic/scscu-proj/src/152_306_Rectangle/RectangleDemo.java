/**
   Program to create a Rectangle object from the Rectangle class
*/

public class RectangleDemo
{
   public static void main(String[] args)
   {
      Rectangle box = new Rectangle(5.0, 15.0);
      
      System.out.println("The box's length is " + box.getLength());
      
      System.out.println("The box's width is " + box.getWidth());
      
      System.out.println("The box's area is " + box.getArea());
   }
}
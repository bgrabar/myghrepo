public class TwoDArrays
{
    public static void main(String[] args)
    {
        int[][] array = new int [5][15]; 
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 15; j++)
            {
              array[i][j] = i;
              System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
  
        System.out.print("\n");
  
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 15; j++)
            {
              array[i][j] = j;
              System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
  
        System.out.print("\n");
  
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 15; j++)
            {
              array[i][j] = Math.abs(9 - (i + j));
              System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
  
        System.out.print("\n");
  
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 15; j++)
            {
              array[i][j] = j;
              System.out.print(i + "," + j + " ");
            }
            System.out.print("\n");
        }
    }
}
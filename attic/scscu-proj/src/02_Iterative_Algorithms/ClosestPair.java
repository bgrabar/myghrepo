/* Closest Pair Algorithm

 n-1     n
(sum)  (sum) j
 i=1   j=i+1

(n-1) + (n+2) + (n-3) + ... 1

 n-1        n(n-1)
(sum)   =   ------
 i=1          2

*/

public class ClosestPair
{
    public static void main(String[] args)
    {
        // Create an array to store points
        int[][] points = { {8, 9}, {5, 3}, {6, 1}, {5, 1}, {8, 4} };
        
        // initial two points
        int p1 = 0, p2 = 1;
        
        // initialize shortest distance
        double shortestDistance = distanceBetweenPoints(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
        
        // Compute distance for every two points
        for (int i = 0; i < points.length; i++)
        {
            for (int j = i + 1; j < points.length; j++)
            {
                double distance = distanceBetweenPoints(points[i][0], points[i][1], points[j][0], points[j][1]);
                
                if (shortestDistance > distance)
                {
                    p1 = i;
                    p2 = j;
                    shortestDistance = distance;
                }
            }
        }
        
        System.out.println("The closest two points are (" + points[p1][0] + "," + points[p1][1] + 
                                       ") and (" + points[p2][0] + "," + points[p2][1] + ")");
    }
    
/* ********************************
   Find distance between two points
   ******************************** */
    public static double distanceBetweenPoints(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
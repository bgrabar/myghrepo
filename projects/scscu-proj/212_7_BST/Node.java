public class Node
{
    private int data;
    private Node left;
    private Node right;
    
    public Node()
    {
        data = 0;
        left = null;
        right = null;
    }
    
    public Node(int d)
    {
        data = d;
        left = null;
        right = null;
    }
    
    public void setData(int d)
    {
        data = d;
    }
    
    public void setLeft(Node t)
    {
        left = t;
    }
    
    public void setRight(Node t)
    {
        right = t;
    }
    
    public Integer getData()
    {
        return data;
    }
    
    public Node getLeft()
    {
        return left;
    }
    
    public Node getRight()
    {
        return right;
    }
}

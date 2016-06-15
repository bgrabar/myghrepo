public class Node
{
    int data;
    Node next;
    
    public Node()  // this constructor is not needed as it's the same as 
                   // the default contructor. It's here for learning purposes
    {
        data = 0;
        next = null;
    }
    
    public Node(int d, Node n)
    {
        data = d;
        next = n;
    }
    
    public void setData(int d)
    {
        data = d;
    }
    
    public void setNext(Node n)
    {
        next = n;
    }
    
    public Integer getData()
    {
        return data;
    }
    
    public Node getNext()
    {
        return next;
    }
    
}
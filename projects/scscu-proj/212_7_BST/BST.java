public class BST
{
    private Node root;
    private long size = 0;
    private String traversalResult = "";
    
    public Long getSize()
    {
        return size;
    }
    
    public Node getRoot()
    {
        return root;
    }
    
    public String getTraversalResult()
    {
        return traversalResult;
    }
    
    public void setTraversalResult(String s)
    {
        traversalResult = s;
    }
    
    public void addToBST(int d)
    {
        Node t = new Node();
        t.setData(d);
        
        if (root == null)
        {
            root = t;
            size ++;
        }
        else
        {
            Node temp = root;
            add(temp, t);
        }
    }
    
    public void add(Node tmp, Node tt)
    {
        while (tt.getData() == tmp.getData())
        {
            tt.setData((tmp.getData() + 3));
        }
        if (tt.getData() < tmp.getData())
        {
            if (tmp.getLeft() == null)
            {
                tmp.setLeft(tt);
                size ++;
            }
            else
            {
                tmp = tmp.getLeft();
                add(tmp, tt);
            }
        }
        else
        {
            if (tmp.getRight() == null)
            {
                tmp.setRight(tt);
                size ++;
            }
            else
            {
                tmp = tmp.getRight();
                add(tmp, tt);
            }
        }
    }
    
    
/*  UNDER CONSTRUCTION
    public void deleteFromBST(int d)
    {
        Node temp = root;
        
        if (temp == null)
        {
            JOptionPane.showMessageDialog(null, " Tree empty, can not delete " + d, 
                "Can NOT delete", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Node parent = null;
        Node child  = root;
        while (child != null)
        {
            parent = child;
            child = child.left;
            
            if (child.left.data == d)
            {
                ;
            }
        }
        if (child.left == null && child.right == null)       // leaf node
        {
            // ??????????????????????????????????
        }
        if (child.left != null && child.right !=null)        // node with both children
        {
            // ??????????????????????????????????
        }
        else if (child.left == null || child.right == null)  // node with one child
        {
            ; // ??????????????????????????????????
        }
    }        */
    
    
    
    public Node searchBST(int d)
    {
        Node t = root;
        if (t == null)
        {
            return null;
        }
        else
        {
            ;  // ????????????
        }
        return null;
    }
    
    public void inOrder(Node t)
    {
       if (t != null)
       {
          inOrder (t.getLeft());
          traversalResult = traversalResult + t.getData() + "  ";
          inOrder (t.getRight());
       } 
    }
    
    public void preOrder(Node t)
    {
      if (t != null)
       {
          traversalResult = traversalResult + t.getData() + "  ";
          preOrder (t.getLeft());
          preOrder (t.getRight());
       } 
    }
    
    public void postOrder(Node t)
    {
      if (t != null)
       {
          preOrder (t.getLeft());
          preOrder (t.getRight());
          traversalResult = traversalResult + t.getData() + "  ";
       } 
    }
}

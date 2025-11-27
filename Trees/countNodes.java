public class countNodes {
    
    static class Node{
        int val;
        Node left,right;
        
        public Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }  
    }
    public static int NumberOfNodes(Node root){
        if(root==null)
            return 0;
        
        int lcount=NumberOfNodes(root.left);
        int rcount=NumberOfNodes(root.right);
        
        return lcount+rcount+1;
    }

    public static int SumOfNodes(Node root){
        if(root==null)
            return 0;

        return SumOfNodes(root.left)+SumOfNodes(root.right)+root.val;
    }
    
    public static void main(String args[]){
         /*
              1
            /   \
           2     3
          / \   / \
         4  5  6   7
        */
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.println(NumberOfNodes(root));
        System.out.println(SumOfNodes(root));
    }
}
import javax.swing.tree.TreeNode;

public class heightBalancedBinaryTree {
    static class Node{
        int val;
        Node left,right;
        
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    public static boolean isBalanced(Node root){
        return checkHeight(root)!=-1;
    }
    
    public static int checkHeight(Node root){
        if(root==null)
            return 0;
        
        int lh=checkHeight(root.left);
        if(lh==-1)return -1;
        
        int rh=checkHeight(root.right);
        if(rh==-1)return -1;
        
        if(Math.abs(lh-rh)>1)return -1;
        
        return Math.max(lh,rh)+1;
    }
    
    public static void main(String args[]){
        Node root=new Node(3);
        root.left=new Node(9);
        root.right=new Node(20);
        root.right.left=new Node(15);
        root.right.right=new Node(7);
        
        System.out.println(isBalanced(root));
    }
}
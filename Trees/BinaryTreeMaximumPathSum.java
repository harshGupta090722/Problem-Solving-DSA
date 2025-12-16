import java.util.*;

public class BinaryTreeMaximumPathSum {
    class Node{
        int val;
        Node left,right;
        
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    static class BuildTree{
       static int idx=-1;
       public static Node buildTree(int root[]){
        idx++;
        if(root[idx]==-1)
            return null;

        Node newNode=new Node(root[idx]);
        newNode.left=buildTree(root);
        newNode.right=buildTree(root);

        return newNode;
       }

       public static int height(Node root){
        if(root==null)
            return 0;
        
        int lh=height(root.left);
        int rh=height(root.right);
        
        return  Math.max(lh,rh)+1;
    }
    }
    public static int maxPathSum(Node root) {
       
    }
    public static void main(String args[]){
        int root[]={-10,9,20,null,null,15,7};
        System.out.println(maxPathSum(null));
    }
}
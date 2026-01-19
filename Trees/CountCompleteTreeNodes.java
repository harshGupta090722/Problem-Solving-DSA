import java.util.*;

public class CountCompleteTreeNodes {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    static int count=0;
    
    public static int countNodes(TreeNode root) {
        Inorder(root);
        
        return count;
    }
    
    public static void Inorder(TreeNode root) {
        if(root==null)
            return;
        
        count++;
        Inorder(root.left);
        Inorder(root.right);
        
    }
    
    
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        root.right.left = new TreeNode(6);
        
        System.out.println(countNodes(root));
    }
}
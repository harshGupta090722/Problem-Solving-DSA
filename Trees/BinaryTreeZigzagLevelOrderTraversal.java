import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    
    static class  TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.right=null;
            this.left=null;
        }
    }
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        
        return list;
    }
    public static void main(String args[]){

        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }
}
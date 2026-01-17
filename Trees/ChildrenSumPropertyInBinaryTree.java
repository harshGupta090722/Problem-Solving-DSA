public class ChildrenSumPropertyInBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) { 
            this.val = val; 
        }
    }
    
    public static boolean checkChildrenSum(TreeNode root) { 
        if(root==null ||(root.left==null && root.right==null))
            return true;
        
        int leftSum=(root.left!=null)?root.left.val:0;
        int rightSum = (root.right != null) ? root.right.val : 0;
        
        if(leftSum+rightSum!=root.val)
            return false;
        
        return checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        
        System.out.println(checkChildrenSum(root));
    }
}
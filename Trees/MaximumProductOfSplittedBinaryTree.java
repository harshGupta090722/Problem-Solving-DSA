public class MaximumProductOfSplittedBinaryTree {
    
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    
    static long maxProduct=0;
    static long TotalSum=0;
    
    public static int maxProduct(TreeNode root) {
        TotalSum=getTotal(root);
        calculateProduct(root);
        return (int)(maxProduct%1000000007);
    }
    
    public static long calculateProduct(TreeNode root){
        if(root==null)
            return 0;
        
        long leftSum=calculateProduct(root.left);
        long rightSum=calculateProduct(root.right);
        
        long subTreeSum=root.val+leftSum+rightSum;
        
        long product=subTreeSum*(TotalSum-subTreeSum);
        maxProduct=Math.max(maxProduct,product);
        
        return subTreeSum;
    }
    
    public static int getTotal(TreeNode root){
        if(root==null)
            return 0;
        
        int leftSum=getTotal(root.left);
        int rightSum=getTotal(root.right);
        
        return root.val+leftSum+rightSum;
    }
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        
        System.out.println(maxProduct(root));
    }
}
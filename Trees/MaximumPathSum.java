public class MaximumPathSum {

    static class  TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.right=null;
            this.left=null;
        }
    }

    public static int maxPathSum(TreeNode root) {
        int maxValue[]=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }
    
    private static int maxPathDown(TreeNode node,int maxValue[]){
        if(node==null)
            return 0;
        
        int left=Math.max(0,maxPathDown(node.left, maxValue));
        int right=Math.max(0,maxPathDown(node.right, maxValue));
        
        maxValue[0]=Math.max(maxValue[0],left+right+node.val);
        return Math.max(left,right)+node.val;
    }
    
    public static void main(String args[]){
        
        TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}
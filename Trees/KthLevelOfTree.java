public class KthLevelOfTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    public static void KLevel(TreeNode root,int level ,int k){
        if(root==null)
            return;
        
        if(level==k){
            System.out.print(root.val+" ");
            return;
        }
        
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }
    public static void main(String args[]){
        /*
              1
           /     \
          2       3
        /  \    /   \        
       4   5   6     7
    */

    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.right.left=new TreeNode(6);
    root.right.right=new TreeNode(7);

    KLevel(root, 1, 3);
    System.out.println();
    }
}
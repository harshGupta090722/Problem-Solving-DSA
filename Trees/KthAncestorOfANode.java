public class KthAncestorOfANode {
    
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    } 
    
    
    public static int KthAncestor(TreeNode root,int n,int k){
        if(root==null)
            return -1;
        
        if(root.val==n)
            return 0;
        
        int leftDist=KthAncestor(root.left, n, k);
        int rightDist=KthAncestor(root.right, n, k);
        
        if(leftDist==-1 && rightDist==-1)
            return -1;
        
        int max=Math.max(leftDist,rightDist);
        
        if(max+1==k)
            System.out.println(root.val);
        
        return max+1;
    }
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        
        KthAncestor(root,5,2);
    }
}
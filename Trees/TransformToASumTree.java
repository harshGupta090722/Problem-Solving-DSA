public class TransformToASumTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    public static int transform(TreeNode root){
        if(root==null)
            return 0;
        
        int leftChild=transform(root.left);
        int rightChild=transform(root.right);
        
        int val=root.val;
        
        int newLeft=root.left==null?0:root.left.val;
        int newright=root.left==null?0:root.right.val;
        
        root.val=newLeft+leftChild+newright+rightChild;
        return val;
    }
    
    public static void preOrder(TreeNode root){
        if(root==null)
            return;
        
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        
        transform(root);
        preOrder(root);
    }   
}
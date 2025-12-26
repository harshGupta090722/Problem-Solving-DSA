public class BuildABST {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    public static TreeNode insert(TreeNode root,int val){
        if(root==null)
            return root=new TreeNode(val);
        
        if(val<root.val)
            root.left=insert(root.left, val);
        else
            root.right=insert(root.right, val);
        
        return root;
    }
    
    public static  void inorder(TreeNode root){
        if(root==null)
            return;
        
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String args[]){
        int values[]={5,1,3,4,2,7};
        TreeNode root=null;
        
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        
        inorder(root);
        System.out.println();
    }
}
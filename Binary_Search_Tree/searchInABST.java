public class searchInABST {
    
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    public static boolean SearchBST(TreeNode root,int key){
        if(root==null)
            return false;
        
        if(root.val==key)
            return true;
        
        if(key<root.val)
            SearchBST(root.left, key);
        else 
            SearchBST(root.right,key );

        return false;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(8);
        
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(14);
        
        if(SearchBST(root, 7)){
            System.out.println("Found");
        }else
            System.out.println("Not found");
    }
}
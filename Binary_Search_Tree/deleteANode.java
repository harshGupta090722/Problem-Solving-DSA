public class deleteANode {
    
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) 
            return null;
        
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            // case 1:leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // case 2:single child
            if (root.left == null){
                return root.right;
            }else  if (root.right == null){
                return root.left;
            }
            
            // case 3:two children
            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }
        return root;
    }
    
    public static TreeNode findInorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    
    public static void main(String args[]) {
        TreeNode root = new TreeNode(8);
        
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(14);
        
        root = delete(root, 8);
        
        inorder(root);
    }
}
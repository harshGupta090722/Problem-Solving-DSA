import java.util.*;
public class LowestCommonAncestor {
    
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null; 
        }
    }
    
    public static boolean getPath(TreeNode root,int n,ArrayList<TreeNode> path){
        if(root==null)
            return false;
        
        path.add(root);
        
        if(root.val==n){
            return true;
        }
        
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);
        
        
        if(foundLeft || foundRight)
            return true;
        
        path.remove(path.size()-1);  
        return false;
    }
    
    public static TreeNode lowestCommonAncestorI(TreeNode root,int n1,int n2) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        getPath(root,n1,path1);
        
        ArrayList<TreeNode> path2=new ArrayList<>();
        getPath(root,n2,path2);
        
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i))
                break;
        }
        
        TreeNode lca=path1.get(i-1);
        return lca;
    }
    
    public static TreeNode lowestCommonAncestorII(TreeNode root,int n1,int n2) {
        if(root==null || root.val==n1 || root.val==n2)
            return root;
        
        TreeNode leftlca=lowestCommonAncestorII(root.left, n1, n2);
        TreeNode rightlca=lowestCommonAncestorII(root.right, n1, n2);
        
        if(rightlca==null)
            return leftlca;
        
        if(leftlca==null)
            return rightlca;
        
        return root;
    }
    
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println(lowestCommonAncestorI(root, 4, 7 ).val);
        System.out.println(lowestCommonAncestorII(root, 4, 6 ).val);
    }
}
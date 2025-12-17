import java.util.*;
public class LowestCommonAncestor {
    
    static class TreeNode{
        int data;
        TreeNode left,right;
        
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null; 
        }
    }
    
    public static boolean getPath(TreeNode root,int n,ArrayList<TreeNode> path){
        if(root==null)
            return false;
        
        path.add(root);
        
        if(root.data==n){
            return true;
        }
        
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);
        
        
        if(foundLeft || foundRight)
            return true;
        
        path.remove(path.size()-1);  
        return false;
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root,int n1,int n2) {
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
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println(lowestCommonAncestor(root, 4, 7 ).data);
    }
}
import java.util.*;

public class printRootToNodePath {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) { 
            data = val; 
        }
    }
    
    public static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> GlobalList=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        
        
        allPaths(root, tempList, GlobalList);
        return GlobalList;
    }
    
    
    public static void allPaths(TreeNode root,List<Integer> tempList ,List<List<Integer>> GlobalList){
        
        if(root==null)
            return;
        
        tempList.add(root.data);
        
        if(root.left==null && root.right==null){  //leaf found        
            GlobalList.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size()-1);  
            return;
        }
        
        if(root.left!=null)
            allPaths(root.left, tempList, GlobalList);
        
        if(root.right!=null)
            allPaths(root.right, tempList, GlobalList);
        
        tempList.remove(tempList.size()-1);
    }    
    
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(4);
        
        System.out.println(allRootToLeaf(root));
    }
}
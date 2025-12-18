import java.util.ArrayList;

public class MinimumDistanceBetweenNodes {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    public  static int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        preOrderTraversal(root,list);
  
        Integer[] arr = list.toArray(new Integer[list.size()]);
        
        int minDifference=Integer.MAX_VALUE;
        
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]>arr[j])
                    minDifference=Math.min(minDifference,arr[i]-arr[j]);
            }
        }
        return minDifference;
    }
    
    public static void preOrderTraversal(TreeNode root,ArrayList<Integer> list) {
        if (root == null)
            return;
        
        list.add(root.val);
        preOrderTraversal(root.left,list);
        preOrderTraversal(root.right,list);
    }
    
    
    static int minDiff=Integer.MAX_VALUE;
    static Integer prev=null;
    
    public static int minDiffInBSTII(TreeNode root){
        inorder(root);
        return minDiff;
    }
    
    private static void inorder(TreeNode root){
        if(root==null)
            return;
        
        inorder(root.left);
        
        if(prev!=null)
            minDiff=Math.min(minDiff,root.val - prev);
        
        prev=root.val;
        
        inorder(root.right);
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(96);
        
        root.left = new TreeNode(12);
        
        root.left.left = null;
        root.left.right = new TreeNode(13);
        
        root.left.right.left = null;
        root.left.right.right = new TreeNode(52);
        
        root.left.right.right.left = new TreeNode(29);
        
        System.out.println(minDiffInBST(root));
    }
}
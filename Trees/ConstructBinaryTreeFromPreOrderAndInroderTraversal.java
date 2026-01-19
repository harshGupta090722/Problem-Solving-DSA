import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderAndInroderTraversal {
    
    private static class TreeNode{
        int val;  
        TreeNode left;
        TreeNode right; 
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    private static int preorderIndex=0;
    private static Map<Integer,Integer> inorderIndexMap=new HashMap<>();
    
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        
        return build(preorder, 0, inorder.length-1);
    }
    
    
    private static TreeNode build(int []preorder,int left,int right){
        if(left>right)
            return null;
        
        int rootVal=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootVal);
        
        int inorderIndex=inorderIndexMap.get(rootVal);
        
        root.left=build(preorder, left, inorderIndex-1);
        root.right=build(preorder, inorderIndex+1, right);
        
        return root;
    }
    
    public static void main(String args[]){
        int preorder[]={3,9,20,15,7};
        int inorder[]={9,3,15,20,7};
        
        System.out.println(buildTree(preorder, inorder).val);
    }
}
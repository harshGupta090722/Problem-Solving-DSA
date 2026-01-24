import java.util.Map;
import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal{
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        } 
    }
    
    public static int postorderIndex;
    public static Map<Integer,Integer> inorderIndexMap=new HashMap<>();
    
    public static TreeNode buildTree(int [] inorder,int [] postorder){
        
        postorderIndex=postorder.length-1;
        
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        
        return build(postorder,0, inorder.length-1);
    }
    
    public static TreeNode build(int postorder[],int left,int right){
        if(left>right)
            return null;
        
        int rootVal=postorder[postorderIndex--];
        TreeNode root=new TreeNode(rootVal);
        
        int inorderIndex=inorderIndexMap.get(rootVal);
        
        root.right=build(postorder, inorderIndex+1, right);
        root.left=build(postorder,left, inorderIndex-1);
        
        return root;
    }
    
    
    public static void main(String args[]){
        int inroder[]={9,3,15,20,7};
        int postorder[]={9,15,7,20,3};
        
        System.out.println(buildTree(inroder, postorder).val);
    }
}
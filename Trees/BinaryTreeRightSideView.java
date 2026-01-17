import java.util.*;

public class BinaryTreeRightSideView {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        queue.add(null);
        
        
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(queue.peek()==null && curr!=null)
                list.add(curr.val);
            
            
            if(curr==null){
                if(queue.isEmpty())
                    break;
                queue.add(null);
            }else{
                if(curr.left!=null)
                    queue.add(curr.left);
                
                if(curr.right!=null)
                    queue.add(curr.right);
                
            }
        }
        
        return list;
    }
    
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        
        System.out.println(rightSideView(root));
    }
}
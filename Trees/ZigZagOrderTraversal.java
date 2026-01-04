import java.util.*;

public class ZigZagOrderTraversal {
    
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    public  static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> level=new ArrayList<>();
        int count=0;
        
        while(!queue.isEmpty()){
            
            TreeNode currentNode=queue.poll();
            
            if(currentNode==null){           //level finished
                
                if(count%2==1){
                    Collections.reverse(level);
                }
                
                ans.add(new ArrayList<>(level));
                level.clear();
                count++;
                
                if(!queue.isEmpty())
                    queue.add(null);
            }else{
                level.add(currentNode.val);
                
                if(currentNode.left!=null)
                    queue.add(currentNode.left);
                
                if(currentNode.right!=null)
                    queue.add(currentNode.right);
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        
        TreeNode root=new TreeNode(1);
        
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        
        System.out.println(zigzagLevelOrder(root));
    }
}
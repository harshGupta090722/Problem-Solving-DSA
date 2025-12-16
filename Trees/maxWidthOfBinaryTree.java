import java.util.*;
public class maxWidthOfBinaryTree {
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    static class Pair{
        TreeNode node;
        long idx;
        
        Pair(TreeNode node,long idx){
            this.node=node;
            this.idx=idx;
        }
    }
    
    public static int WidthOfBinaryTree(TreeNode root){
        if(root==null)
            return 0;
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        
        int maxWidth=0;
        
        
        while(!q.isEmpty()){
            int size=q.size();
            
            long minIdx=q.peek().idx;
            long first=0,last=0;
            
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                long idx=curr.idx-minIdx;
                
                if(i==0)
                    first=idx;
                
                if(i==size-1)
                    last=idx;
                
                if(curr.node.left!=null)
                    q.offer(new Pair(curr.node.left,2*idx));
                
                if(curr.node.right!=null)
                    q.offer(new Pair(curr.node.right,2*idx+1));
            }
            maxWidth=Math.max(maxWidth,(int)(last-first+1));
        }
        return maxWidth;
    }
    
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(9);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(3);
        
        System.out.println(WidthOfBinaryTree(root));
    }
}
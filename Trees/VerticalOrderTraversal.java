import java.util.*;

public class VerticalOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left,right;
        
        TreeNode(int val) {
            this.val = val;
            this.left=null;
            this.right=null;
        }
    }
    
    static class Info{
        TreeNode node;
        int hd;
        int vd;
        
        
        Info(TreeNode node,int hd,int vd){
            this.node=node;
            this.hd=hd;
            this.vd=vd; 
        }
    }
    
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Info> nodes=new ArrayList<>();
        
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(root, 0,0));
        
        int minV=0,maxV=0;
        
        
        while (!q.isEmpty()) {
            Info curr=q.remove();
            nodes.add(curr);
            
            minV=Math.min(minV,curr.vd);
            maxV=Math.max(maxV,curr.vd);
            
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left, curr.hd+1, curr.vd-1));
            }
            
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right, curr.hd+1, curr.vd+1));
            } 
        }
        
        Collections.sort(nodes,(a,b)->{
            if(a.vd!=b.vd) return a.vd-b.vd;
            if(a.hd!=b.hd) return a.hd-b.hd;
            
            return a.node.val-b.node.val;
        });
        
        List<List<Integer>> result=new ArrayList<>();
        
        int prevVd=Integer.MIN_VALUE;
        List<Integer> column=null;
        
        for(Info info:nodes){
            if(info.vd!=prevVd){
                column=new ArrayList<>();
                result.add(column);
                prevVd=info.vd;
            }
            column.add(info.node.val);
        }
        
        return result;
    }
    
    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        
        System.out.println(verticalTraversal(root));
    }
}
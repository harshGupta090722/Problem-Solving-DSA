import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        buildParentMap(root,null,parent);
        
        
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        
        
        queue.add(target);
        visited.add(target);
        
        
        int distance=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            if(distance==k){
                List<Integer> result=new ArrayList<>();
                for(TreeNode node:queue){
                    result.add(node.val);
                }
                return result;
            }
            
            
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                
                if(curr.left!=null && visited.add(curr.left))
                    queue.add(curr.left);
                
                if(curr.right!=null && visited.add(curr.right))
                    queue.add(curr.right);
                
                
                if(parent.get(curr)!=null && visited.add(parent.get(curr)))
                    queue.add(parent.get(curr));
            }
            distance++;
        }
        return new ArrayList<>();
    }
    
    
    public static void buildParentMap(TreeNode node,TreeNode par,Map<TreeNode,TreeNode> parent){
        if(node==null)
            return;
        
        
        parent.put(node,par);
        buildParentMap(node.left,node,parent);
        buildParentMap(node.right,node,parent);
    }
    
    
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        TreeNode target=root.left;
        int k=2;
        
        System.out.println(distanceK(root,target,k));
    }
}
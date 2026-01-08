import java.util.*;

public class BottomViewOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    static class Info{
        Node node;
        int hd;
        int vd;
        
        Info(Node node,int hd,int vd){
            this.node=node;
            this.hd=hd;
            this.vd=vd;
        }
    }
    
    public static ArrayList<Integer> bottomView(Node root) {
        List<Info> list=new ArrayList<>();
        int minV=0,maxV=0;
        
        
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(root,0,0));
        
        
        while (!q.isEmpty()) {
            Info curr=q.poll();
            
            list.add(curr);
            
            minV=Math.min(minV,curr.vd);
            maxV=Math.max(maxV,curr.vd);
            
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left,curr.hd+1, curr.vd-1));
            }
            
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right,curr.hd+1, curr.vd+1));
            }
        }
        
        
        Collections.sort(list,(a,b)->{
            if(a.vd!=b.vd) return a.vd-b.vd;
            if(a.hd!=b.hd) return b.hd-a.hd;
            
            return a.node.data-b.node.data;
        });
        
        ArrayList<Integer> ans=new ArrayList<>();
        Integer lastVd=null;
        
        for(Info info:list){    
            if(lastVd==null || info.vd!=lastVd){
                ans.add(info.node.data);
                lastVd=info.vd;
            }
        }
        
        return ans;
    }
    
    public static void main(String args[]){
        Node root = new Node(9);
        
        root.left = new Node(6);
        root.right = new Node(6);
        
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        
        root.right.left = new Node(2);
        root.right.right = new Node(7);
        
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(1);
        
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(11);
        
        root.right.left.left.left = new Node(11);
        root.right.left.left.right = new Node(9);
        
        root.right.right.right.left = new Node(8);
        root.right.right.right.right = new Node(1);
        
        System.out.println(bottomView(root));
    }
}
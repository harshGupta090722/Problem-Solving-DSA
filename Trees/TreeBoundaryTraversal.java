import java.util.*;

public class TreeBoundaryTraversal {
    
    public static class Node {
        int data;
        Node left, right;
        
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    
    public static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if (root == null) 
            return list;
        
        if(!isLeaf(root))
            list.add(root.data);
        
        addLeftBoundary(root, list);
        addLeaves(root, list);
        addRightBoundary(root,list);
        
        return list;
    }
    
    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    
    public static void addLeftBoundary(Node root, ArrayList<Integer> list) {
        Node curr=root.left;
        
        
        while(curr!=null){
            if(!isLeaf(curr))
                list.add(curr.data);
            
            
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
        }
    }
    
    public static void addLeaves(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        
        if(isLeaf(root)){
            list.add(root.data);
            return;
        }
        
        if(root.left!=null)
            addLeaves(root.left, list);
        
        if(root.right!=null)
            addLeaves(root.right, list);
    }
    
    public static void addRightBoundary(Node root, ArrayList<Integer> list) {
        Node cur=root.right;
        
        ArrayList<Integer> tmp=new ArrayList<>();
        
        while(cur!=null){
            if(!isLeaf(cur))
                tmp.add(cur.data);
            
            if(cur.right!=null)
                cur=cur.right;
            else
                cur=cur.left;
        }
        
        for(int i=tmp.size()-1;i>=0;i--){
            list.add(tmp.get(i));
        }
    }
    
    public static void main(String args[]) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);
        
        System.out.println(boundaryTraversal(root));
    }
}
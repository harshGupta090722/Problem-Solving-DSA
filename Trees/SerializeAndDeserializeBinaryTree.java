import java.util.*;
public class SerializeAndDeserializeBinaryTree{
    static  class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
        }
    }
    
    
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        
        Queue<TreeNode> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (curr == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(curr.val));
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        
        int i = list.size() - 1;
        while (i >= 0 && list.get(i).equals("null")) {
            i--;
        }
        
        list = list.subList(0, i + 1);
        
        return "[" + String.join(",", list) + "]";
    }
    
    
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("[]"))
            return null;

        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int i = 1;
        
        while (!q.isEmpty() && i < values.length) {
            TreeNode curr = q.poll();
            
            if (!values[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;
            
            if (i < values.length && !values[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        
        return root;
    }
    
    
    public static void main(String args[]){
        
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        System.out.println(serialize(root));
    }
}
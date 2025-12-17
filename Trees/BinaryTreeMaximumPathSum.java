public class BinaryTreeMaximumPathSum {
    static class Node{
        int val;
        Node left,right;
        
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    static int maxSum=Integer.MIN_VALUE;
    
    public static int maxPathSum(Node root) {
        dfs(root);
        return maxSum;
    }
    
    private static int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));
        
        int currentPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);
        
        return node.val + Math.max(leftGain, rightGain);
    }
    public static void main(String args[]){
        
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(maxPathSum(root));
    }
}
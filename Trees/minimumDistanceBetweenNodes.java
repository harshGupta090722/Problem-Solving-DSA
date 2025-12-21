public class minimumDistanceBetweenNodes {
    static class TreeNode{
        int val;
        TreeNode left,right;
        
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    public static TreeNode lowestCommonAncestorII(TreeNode root,int n1,int n2) {
        if(root==null || root.val==n1 || root.val==n2)
            return root;
        
        TreeNode leftlca=lowestCommonAncestorII(root.left, n1, n2);
        TreeNode rightlca=lowestCommonAncestorII(root.right, n1, n2);
        
        if(rightlca==null)
            return leftlca;
        
        if(leftlca==null)
            return rightlca;
        
        return root;
    }
    
    public static int lcaDist(TreeNode root,int n){
        if(root==null)
            return -1;
        
        if(root.val==n)
            return 0;
        
        int leftDist=lcaDist(root.left,n);
        int rightDist=lcaDist(root.right,n);
        
        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist==-1)
            return rightDist+1;
        else
            return leftDist+1;
    }
    
    public static int minDistance(TreeNode root,int p ,int q){
        TreeNode lca=lowestCommonAncestorII(root, p, q);
        
        int dist1=lcaDist(lca,p);
        int dist2=lcaDist(lca,q);
        
        return dist1+dist2;
    }
    
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        
        System.out.println(minDistance(root, 4, 6));
    }
}

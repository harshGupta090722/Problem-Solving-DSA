import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

public class MaximumTimeTakenToBrunTheBTfromAGivenNode {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static int timeToBurnTree(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = findStartAndBuildParent(root, null, parent, start);

        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        int TotalTime = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null && visited.add(curr.left))
                    queue.add(curr.left);

                if (curr.right != null && visited.add(curr.right))
                    queue.add(curr.right);

                if (parent.get(curr) != null && visited.add(parent.get(curr)))
                    queue.add(parent.get(curr));
            }
            TotalTime++;
        }

        return TotalTime - 1;
    }

    public static TreeNode findStartAndBuildParent(TreeNode node,TreeNode par,HashMap<TreeNode, TreeNode> parent,int start) {
        if (node == null)
            return null;

        parent.put(node, par);

        if (node.data == start)
            return node;
 
        TreeNode left = findStartAndBuildParent(node.left, node, parent, start);
        if (left != null)
            return left;

        return findStartAndBuildParent(node.right, node, parent, start);
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int start = 1;

        System.out.println(timeToBurnTree(root, start));
    }
}
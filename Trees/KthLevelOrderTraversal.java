public class KthLevelOrderTraversal {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static void printNodes(Node root, int level, int K) {
        if (root == null)
            return;

        if (level == K) {
            System.out.print(root.val+" ");
            return;
        }

        printNodes(root.left, level + 1, K);
        printNodes(root.right, level + 1, K);
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int k = 3;
        printNodes(root, 1, k);
    }
}
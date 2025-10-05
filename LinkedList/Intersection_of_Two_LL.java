public class Intersection_of_Two_LL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        
        while (tempA != tempB) {

            if (tempA == null)
                tempA = headB;

            if (tempB == null)
                tempB = headA;

            tempA = tempA.next;
            tempB = tempB.next;
            if (tempA == tempB)
                return tempA;
        }
        return null;
    }

    public static void main(String[] args) {
        // Create first linked list: 1 -> 2 -> 3 -> 6 -> 7
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);

        // Create second linked list: 4 -> 5 -> 6 -> 7
        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);

        // Create intersection node 6 -> 7
        ListNode intersect = new ListNode(6);
        intersect.next = new ListNode(7);

        // Attach intersection to both lists
        headA.next.next.next = intersect;
        headB.next.next = intersect;

        // Call the function
        Intersection_of_Two_LL sol = new Intersection_of_Two_LL();
        ListNode result = sol.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
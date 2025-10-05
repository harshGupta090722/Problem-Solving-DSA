class removeNthNodeFromTheList {
    // Make ListNode static so it can be used in static main
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1)
            return null;
        else if (head.next.next == null && n == 1) {
            head.next = null;
            return head;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int n1 = count - n;
        temp = head;
        while (temp != null && temp.next.next != null) {
            n1--;
            if (n1 == 0) {
                System.out.println("The cruicial node is " + temp.val);
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Create Linked List: 1 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        int n = 1; // Remove 2nd node from end → expected: 1
        ListNode result = removeNthFromEnd(head, n);

        // Print the list after removal
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
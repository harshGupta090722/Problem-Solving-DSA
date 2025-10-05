class deleteMiddleNode {
    static class ListNode { 
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        else if (head.next.next == null) {
            head.next = null;
            return head;
        } 

        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input: [1,2,3,4,5,6,7]
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

        System.out.println("Original List:");
        printList(head);

        head = deleteMiddle(head); // delete middle node

        System.out.println("Modified List:");
        // Example Output:[1,2,3,5,6,7]
        printList(head);
    }
}

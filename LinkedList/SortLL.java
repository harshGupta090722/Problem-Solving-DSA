class SortLL {
    public static class ListNode {
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

    public ListNode sortList(ListNode head) {

        ListNode zeroDummy = new ListNode(0);
        ListNode oneDummy = new ListNode(1);
        ListNode twoDummy = new ListNode(2);

        ListNode l0 = zeroDummy, l1 = oneDummy, l2 = twoDummy;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                l0.next = temp;
                l0 = l0.next;
            } else if (temp.val == 1) {
                l1.next = temp;
                l1 = l1.next;
            } else {
                l2.next = temp;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        l0.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        l1.next = twoDummy.next;
        l2.next = null; 

        return zeroDummy.next;
    }

    public static void main(String[] args) {
        // Build example linked list: 1 -> 0 -> 2 -> 0 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(1);

        SortLL sol = new SortLL();
        ListNode sorted = sol.sortList(head);

        // Print sorted list
        printList(sorted);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
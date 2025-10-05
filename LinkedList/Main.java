class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode addOne(ListNode head) {
        ListNode revHead = reverseLinkedList(head);
        ListNode temp = revHead;

        int carry = 1;
        ListNode prev = null;

        while (temp != null) {
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;

            prev = temp;
            temp = temp.next;
        }

        if (carry > 0)
            prev.next = new ListNode(carry);

        return reverseLinkedList(revHead);
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create linked list: 9 -> 9 -> 9 -> null
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        Solution sol = new Solution();
        ListNode newHead = sol.addOne(head);

        // Print the resulting linked list
        printList(newHead);
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}

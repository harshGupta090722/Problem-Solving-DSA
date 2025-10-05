public class AddTwoNumbers {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
ListNode tail1 = reverseLinkedList(l1);
        ListNode tail2 = reverseLinkedList(l2);

        ListNode ans = new ListNode(0);
        ListNode temp3 = ans;

        ListNode temp1 = tail1;
        ListNode temp2 = tail2;
        int carry = 0;

        while (temp1 != null || temp2 != null || carry != 0) {
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            temp3.next = new ListNode(sum % 10);
            temp3 = temp3.next;

            temp1 = (temp1 != null) ? temp1.next : null;
            temp2 = (temp2 != null) ? temp2.next : null;
        }

        return reverseLinkedList(ans.next);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Resultant List:");
        printList(result);
    }
}
public class RotateList {
    static class ListNode {   
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
            return head;

        ListNode temp = head, tail = head;
        int size = 0;
        
        while (temp != null) {
            temp = temp.next;
            size++;
            if (temp!=null && temp.next == null)
                tail = temp;
        }
        
        k=k%size;

        temp=head;
        while(size-k-1>0){
         temp=temp.next;
         size--;
        }
        
        ListNode newHead=temp.next;
        temp.next=null;

        tail.next=head;
        return newHead;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // create sample list:1->2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.print("Original List: ");
        printList(head);

        int k = 0;
        ListNode rotated = rotateRight(head, k);

        System.out.print("Rotated List by " + k + ": ");
        printList(rotated);
    }
}
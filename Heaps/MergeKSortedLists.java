import java.util.*;
public class MergeKSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(ListNode head:lists){
            while(head!=null){
                pq.add(head.val);
                head=head.next;
            }
        }
        
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        
        while(!pq.isEmpty()){
            curr.next=new ListNode(pq.poll());
            curr=curr.next;
        }
        
        return dummy.next;
    }
    
    public static ListNode buildList(int arr[]){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        
        for(int i=0;i<arr.length;i++){
            curr.next=new ListNode(arr[i]);
            curr=curr.next;
        }
        
        return dummy.next;
    }
    
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
            if(head.next==null){
                System.out.print(head.val);
                break;
            }
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        ListNode l1=buildList(new int[]{1,4,5});
        ListNode l2=buildList(new int[]{1,3,4}); 
        ListNode l3=buildList(new int[]{2,6});
        
        ListNode lists[]=new ListNode[]{l1,l2,l3};
        
        ListNode merged=mergeKLists(lists);
        print(merged);
    }
}
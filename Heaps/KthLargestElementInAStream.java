import java.util.*;
public class KthLargestElementInAStream {
    
    int k;
    PriorityQueue<Integer> minHeap;
    
    public KthLargestElementInAStream(int k, int[] nums) { 
        this.k=k;
        this.minHeap=new PriorityQueue<>();
        
        for(int num:nums){
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        if(minHeap.size()>k){
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
    
    public static void main(String args[]){
        KthLargestElementInAStream kobj =new KthLargestElementInAStream(3, new int[]{4,5,8,2});
        
        System.out.println(kobj.add(3));  // 4
        System.out.println(kobj.add(5));  // 5
        System.out.println(kobj.add(10)); // 5
        System.out.println(kobj.add(9));  // 8
        System.out.println(kobj.add(4));  // 8   
    }
}
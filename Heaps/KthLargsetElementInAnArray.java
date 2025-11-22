import java.util.*;
public class KthLargsetElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        for(int i:nums){
            if(pq.size()<k)
                pq.add(i);
            else if(pq.size()==k){
                if(i>pq.peek()){
                    pq.remove();
                    pq.add(i);
                }
            }
        }
        return pq.peek();
    }
    public static void main(String args[]){
        int nums[]={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(nums, k)); 
    }
}
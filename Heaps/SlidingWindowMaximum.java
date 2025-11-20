import java.util.*;

public class SlidingWindowMaximum {
    
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        
        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        
        @Override
        public int compareTo(Pair p2){
            return p2.val-this.val;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int k=3;
        int arr[]={1,3,-1,-3,5,3,6,7};
        int n=arr.length;
        
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));
        }
        
        int ans[]=new int[n-k+1];
        ans[0]=pq.peek().val;
        int idx=1;
        
        for(int i=k;i<n;i++){
            
            while(pq.size()>0 && pq.peek().idx<=(i-k)){
                pq.remove();
            }
            
            pq.add(new Pair(arr[i],i));
            ans[idx]=pq.peek().val;
            idx++;
        }
        
        System.out.println(Arrays.toString(ans));
    }   
}
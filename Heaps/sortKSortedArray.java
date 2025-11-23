import java.util.Arrays;
import java.util.PriorityQueue;

public class sortKSortedArray{
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=arr.length;
        
        for(int i=0;i<k+1;i++){
            pq.add(arr[i]);
        }
        
        int idx=0;
        for(int i=k+1;i<n;i++){
            arr[idx]=pq.remove();
            idx++;
            pq.add(arr[i]);
        }
        
        while(!pq.isEmpty()){
            arr[idx]=pq.remove();
            idx++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,4};
        int k=2;
        nearlySorted(arr,k);
    }
}
import java.util.Arrays;

public class ShortestJobFirst {
    
    public static long solve(int[] bt) {
        int n=bt.length;
        Arrays.sort(bt);
        int local_waiting_time=0,total_waiting_time=0;
        
        for(int i=0;i<n-1;i++){
            local_waiting_time+=bt[i]; 
            total_waiting_time+=local_waiting_time;
        }
        return total_waiting_time/n;
    } 
    public static void main(String args[]){
        int bt[]={4,1,3,7,2};
        System.out.println(solve(bt));
    }   
}
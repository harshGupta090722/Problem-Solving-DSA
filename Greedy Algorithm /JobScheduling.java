import java.util.*;

public class JobScheduling {
    public static int[] jobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs,(a,b)->Integer.compare(b[2], a[2]));
        
        int n=Jobs.length,maxProfit=0,time_elapsed=0;;
        
        for(int i=0;i<n;i++){
            if(time_elapsed<Jobs[i][1]){
                time_elapsed+=1;
                maxProfit+=Jobs[i][2];
            }
        }
        return new int[]{time_elapsed,maxProfit};
    }
    public static void main(String args[]){
        int Jobs[][]={
            {1,3,100},
            {4,1,60},
            {3,1,50},
            {2,3,20}}; 
            System.out.println(Arrays.toString(jobScheduling(Jobs)));
        }
    }
    
    /*Incorrect solution for test example-{1,3,100}
    {4,1,60}
    {3,1,50}
    {2,3,20}
    */
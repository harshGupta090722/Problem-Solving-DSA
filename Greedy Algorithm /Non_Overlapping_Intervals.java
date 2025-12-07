import java.util.*;

public class Non_Overlapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int n=intervals.length;
        
        int lastEnd=intervals[0][1];
        int max_non_overlapping_interval=1;
        
        for(int i=1;i<n;i++){
            if(lastEnd<=intervals[i][0]){
                max_non_overlapping_interval++;
                lastEnd=intervals[i][1];
            }
        }
        return n-max_non_overlapping_interval;
    }
    public static void main(String args[]){
        int intervals[][]={{1,2},{2,3},{3,4}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
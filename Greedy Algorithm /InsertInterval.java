import java.util.*;
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int []> result=new ArrayList<>();
        int i=0;
        
        while(i<n && intervals[i][1]<newInterval[0]){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        
        int mergedStart=newInterval[0];
        int mergeEnd=newInterval[1];
    
        while(i<n && intervals[i][0]<=mergeEnd){
            mergedStart=Math.min(mergedStart,intervals[i][0]);
            mergeEnd=Math.max(mergeEnd,intervals[i][1]);
            i++;
        }
        
        result.add(new int[]{mergedStart,mergeEnd});
        
        while(i<n){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        
        int [][]ans=new int[result.size()][2];
        for(int j=0;j<result.size();j++){
            ans[j]=result.get(j);
        }
        return ans;
    }
    
    private static void printIntervals(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String args[]){
        int intervals1[][]={{1,3},{6,9}};
        int newInterval1[]={2,5};
        printIntervals(insert(intervals1, newInterval1));
        int intervals[][]={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int newInterval[]={4,8};
        printIntervals(insert(intervals, newInterval));
    }
}
import java.util.*;

public class CheckKSortedArray {
    static class Pair{
        int originalIndex;
        int val;
        
        Pair(int originalIndex,int val){
            this.originalIndex=originalIndex;
            this.val=val;
        }
    }
    
    static String isKSortedArray(int arr[], int n, int k) {
        Pair pair[]=new Pair[n];
        
        for(int i=0;i<n;i++){
            pair[i]=new Pair(i,arr[i]);
        }
        
        Arrays.sort(pair,(a,b)->Integer.compare(a.val, b.val));
        
        for(int sortedIndex=0;sortedIndex<n;sortedIndex++){
            int originalIndex=pair[sortedIndex].originalIndex;
            int diff=Math.abs(originalIndex-sortedIndex);
            if(diff>k)
                return "NO";
        }
        return "YES";
    }
    public static void main(String args[]){
        int arr[]={3,2,1,5,6,4};
        int k=2;
        int n=arr.length;
        System.out.println(isKSortedArray(arr, n, k));
    }
}
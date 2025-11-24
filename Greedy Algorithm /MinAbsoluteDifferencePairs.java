import java.util.Arrays;

public class MinAbsoluteDifferencePairs {
    public static void main(String args[]){
        int A[]={4,1,8,7};
        int B[]={2,3,6,5};
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int minSum=0;
        for(int i=0;i<A.length;i++){
            minSum+=Math.abs(A[i]-B[i]);
        }
        System.out.println(minSum);
    }
}
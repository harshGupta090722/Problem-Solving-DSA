1)Using DP precomputation Or prefix-suffix minimum method O(n) O(n)
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //left max
        int lm[]=new int[n];
        int lmax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
        lmax=Math.max(lmax,height[i]);
        lm[i]=lmax;
        }

        //right max
        int rm[]=new int[n];
        int rmax=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
        rmax=Math.max(rmax,height[i]);
        rm[i]=rmax;
        }

        //Calculate Sum
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.min(lm[i],rm[i])-height[i];
        }
        return sum;
    }
}
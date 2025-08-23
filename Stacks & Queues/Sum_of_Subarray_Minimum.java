class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;

        int []left=new int[n];
        int []right=new int[n];
        
        //Monotonic Stack for previous less element
        Stack<int[]> stack1=new Stack<>();
        for(int i=0;i<n;i++){
            int cnt=1;
            while(!stack1.isEmpty() && stack1.peek()[0]>arr[i]){
                cnt+=stack1.pop()[1];
            }
            left[i]=cnt;
            stack1.push(new int[]{arr[i],cnt});
        }
         
         //Monotonic stack for next less or equal element
         Stack<int[]> stack2=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int cnt=1;
            while(!stack2.isEmpty() && stack2.peek()[0]>=arr[i]){
                cnt+=stack2.pop()[1];
            }
            right[i]=cnt;
            stack2.push(new int[]{arr[i],cnt});
        }
        //final sum 
        long ans=0;
        for(int i=0;i<n;i++){
            ans=(ans+(long)arr[i]*left[i]*right[i])%mod;
        }
        return (int)ans;
    }
}
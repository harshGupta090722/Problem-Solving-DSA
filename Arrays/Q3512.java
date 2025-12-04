public class Q3512 {
    public static int minOperations(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return sum%k;
    }
    public static void main(String args[]){
        int nums[]={3,2};
        System.out.println(minOperations(nums,6));
    }
}
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxIdx=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIdx)return false;
            maxIdx=Math.max(maxIdx,i+nums[i]);
        }
        return true;
    }
    
    public static void main(String args[]){
        int nums[]={2,3,1,1,4};
        //System.out.println(canJump(nums));
        System.out.println(canJump(nums));
    }
}
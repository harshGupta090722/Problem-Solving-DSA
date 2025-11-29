public class JumpGameII {
    public static int jump(int[] nums) {
        int maxIdx=0,currentEnd=0,count=0;
        
        for(int i=0;i<nums.length-1;i++){
            
            maxIdx=Math.max(maxIdx,i+nums[i]);
            if(i==currentEnd){
                count++;
                currentEnd=maxIdx;
            }
        }
        return count;
    }
    
    public static void main(String args[]){
        int nums[]={2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
public class ArrayIsMinHeapOrNot {
    
    public static boolean isHeap(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(2*i+1<n){
                if(nums[2*i+1]<nums[i])
                    return false;
            }
            if(2*i+2<n){
                if(nums[2*i+2]<nums[i])
                    return false; 
            }
        }
        return true;
    }
    public static void main(String args[]){
        int nums[]={10,20,30,21,23};
        System.out.println(isHeap(nums));
    }
}
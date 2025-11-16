import java.util.*;

public class SubarraysWithKDifferentIntegers {
    /* public static int subarraysWithKDistinct(int[] nums, int k) {
    int n=nums.length,count=0;
    if(k==0 || n==0)
    return 0;
    
    for(int i=0;i<n;i++){
    Map<Integer,Integer> map=new HashMap<>();
    for(int j=i;j<n;j++){
    map.put(nums[j],map.getOrDefault(nums[k], 0)+1);
    
    if(map.size()==k)
    count++;
    
    if(map.size()>k)
    break;
    }
    }
    return count;
    }*/
    public static int subarraysWithKDistincthelper(int[] nums, int k) {
        if(k<0)
        return 0;
        
        Map<Integer,Integer> map=new HashMap<>();
        int left=0,right=0,count=0;
        
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right], 0)+1);
            
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                
                if(map.get(nums[left])==0)
                map.remove(nums[left]);
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
    
    public static int subarraysWithKDistinct(int []nums ,int k){
        return subarraysWithKDistincthelper(nums, k)-subarraysWithKDistincthelper(nums, k-1);
    }
    public static void main(String args[]) {
        int nums[] = {1,2,1,3,4};
        System.out.println(subarraysWithKDistinct(nums, 3));
    }
}
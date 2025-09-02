public class removeDuplicates {
    public static  int removeduplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
    public static void print(int arr[]){
        System.out.print("Array is =");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
    public static void main(String[] args) {
     int nums[]={1,1,2};
     System.out.println("The number of unique elements in the array is="+removeduplicates(nums));
     print(nums);
    }
}
/*compare with index of  i!=i-1 and start loop from i=1
🔑 Improvements Over Yours

Edge case: If nums is empty, yours fails (nums[0] doesn’t exist). → Fixed.

More natural loop: Start from i=1 (since nums[0] is always unique). This avoids looking at i+1 and makes it easier to reason about.

Compare with previous (nums[i-1]) instead of next (nums[i+1]):

Safer (no index out of bounds at the end).

Matches the "two-pointer overwrite" template used in similar LeetCode problems.

Cleaner & more standard: Matches the official editorial solution, so it’s instantly recognizable in interviews.
*/
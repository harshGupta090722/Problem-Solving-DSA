public class RearrangeElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int positive = 0, negative = 1;
        int newarr[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                newarr[positive] = nums[i];
                positive += 2;
            } else {
                newarr[negative] = nums[i];
                negative += 2;
            }
        }
        return newarr;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 1, -2, -5, 2, -4 };
        int newarr[] = rearrangeArray(arr);
        for (int i : newarr) {
            System.out.print(i + " ");
        }
    }
}
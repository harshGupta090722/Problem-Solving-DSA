package Arrays;
public class reverse {

    public static void reverseArray(int arr[], int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int temp = arr[startIdx];
        arr[startIdx] = arr[endIdx];
        arr[endIdx] = temp;
        reverseArray(arr, startIdx + 1, endIdx - 1);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        reverseArray(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
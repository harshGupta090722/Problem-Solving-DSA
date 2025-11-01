import java.util.*;
class NumberOfGreaterElementsToTheRight {
    public static List<Integer> count_NGE(int[] arr, int[] indices) {
        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < indices.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[indices[i]] < arr[j])
                    count++;
            }
            result.add(count);
            count = 0;
        }
        return result;
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,1};
        int indices[]={0,3};
        System.out.println(count_NGE(arr,indices));
    }
}
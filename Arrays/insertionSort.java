class insertionSort {

    public static void insertionsort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6 };
        insertionsort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

/*
Dry Run for  i=4
5 11 12 13 6
5 11 12 13 13
5 11 12 12 13
5 11 11 12 13
5 6 11 12 13

No swapping is done !!
*/
import java.util.Arrays;

public class HeapSort {
    
    public static void heapify(int arr[],int i,int size){
        int maxIdx=i;
        int leftChild=2*i+1;
        int rightChild=2*i+2;
        
        if(leftChild<size && arr[leftChild]>arr[maxIdx]){
            maxIdx=leftChild;
        }
        
        if(rightChild<size && arr[rightChild]>arr[maxIdx]){
            maxIdx=rightChild;
        }
        
        if(i!=maxIdx){
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;
        }
    }
    
    
    public static void heapSort(int arr[]){
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        
        for(int i=n-1;i>=0;i--){
            
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            
            heapify(arr,0, i);
        }
    }

    public static void main(String args[]){
        int arr[]={100,21,4,50,3};
        heapSort(arr);
        
        System.out.println(Arrays.toString(arr));
    }
}
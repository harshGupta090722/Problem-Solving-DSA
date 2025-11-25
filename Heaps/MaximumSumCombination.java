import java.util.*;
public class MaximumSumCombination {
    
    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {    
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((x,y)->y-x);
        
        for(int i:a){
            for(int j:b){
                maxHeap.add(i+j);
            }   
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        
        while(k>0 && !maxHeap.isEmpty()){
            list.add(maxHeap.poll());
            k--;
        }

        return list;
    }
    
    public static void main(String args[]){
        int a[]={3,2};
        int b[]={1,4};
        System.out.println(topKSumPairs(a, b, 2)); 
    }
}
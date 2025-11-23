import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {
    
    public static int[] arrayRankTransform(int[] arr) {
        int temp[]=arr.clone();
        
        Arrays.sort(temp);
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int rank=1;
        int n=temp.length;
        
        for(int i:temp){
            if(!map.containsKey(i)){
                map.put(i,rank);
                rank++;
            }
        }
        
        for(int i=0;i<n;i++){
         arr[i]=map.get(arr[i]);
        }
        return arr;
    }
    public static void main(String args[]){
        int arr[]={40,10,20,30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
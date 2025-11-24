import java.util.*;

public class HandsOFStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int val:hand){
            pq.add(val);
        }
        
        while(!pq.isEmpty()){
            int smallest=pq.remove();
            for(int i=1;i<groupSize;i++){
                if(pq.remove(smallest+i))
                    continue;
                else 
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        int hand[]={1,2,3,6,2,3,4,7,8};
        int groupSize=3; 
        System.out.println(isNStraightHand(hand,groupSize));
    }
}
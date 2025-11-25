import java.util.*;
public class ConnectNRopes{
    
    public static  int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int num:sticks){
            pq.add(num);
        }
        int cost=0;
        
        while (pq.size()!=1) {
            int min1=pq.remove();
            int min2=pq.remove();
            int sum=min1+min2;
            cost+=sum;
            pq.add(sum);
        }
        
        return cost;
    }
    public static void main(String args[]){
        ArrayList<Integer> sticks=new ArrayList<>(Arrays.asList(1,8,3,5));
        System.out.println(connectSticks(sticks));
    }
}
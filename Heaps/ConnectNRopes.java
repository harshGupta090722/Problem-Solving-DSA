import java.util.PriorityQueue;

public class ConnectNRopes {
    
    public static void main(String args[]){
        int ropes[]={2,3,3,4,6};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:ropes){
            pq.add(i);
        }
        
        int cost=0;
        while(pq.size()!=1){
            int min1=pq.remove();
            int min2=pq.remove();
            
            int sum=min1+min2;
            cost+=sum;
            pq.add(sum);
        }
        System.out.println("Cost of connecting n ropes="+cost);
    }
}
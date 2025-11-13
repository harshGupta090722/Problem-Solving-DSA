import java.util.*;

class PriorityQueueExample{
    public static void main(String  args[]){
    PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());

    pq.add(10);
    pq.add(5);
    pq.add(20);

    System.out.println(pq);

    System.out.println(pq.peek());

    System.out.println(pq.poll());

    System.out.println(pq);
    }
}
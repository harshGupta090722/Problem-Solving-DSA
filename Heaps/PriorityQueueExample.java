import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pg = new PriorityQueue<>(Comparator.reverseOrder());

        pg.add(4);
        pg.add(1);
        pg.add(46);
        pg.add(49);
        pg.add(41);

        while (!pg.isEmpty()) {
            System.out.println(pg.peek());
            pg.remove();
        }
    }
}
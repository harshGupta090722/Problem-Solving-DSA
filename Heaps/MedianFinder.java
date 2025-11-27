import java.util.*;
public class MedianFinder {
    
    static PriorityQueue<Integer> left_max_heap;
    static PriorityQueue<Integer> right_min_heap;
    
    public MedianFinder() {
        left_max_heap=new PriorityQueue<>((a,b)->b-a);
        right_min_heap=new PriorityQueue<>();
    }
    
    public static void addNum(int num) {
        if(left_max_heap.isEmpty() || num<=left_max_heap.peek())
            left_max_heap.offer(num);
        else
            right_min_heap.offer(num);
        
        if(left_max_heap.size()>right_min_heap.size()+1)
            right_min_heap.offer(left_max_heap.poll());
        else if(right_min_heap.size()>left_max_heap.size())
            left_max_heap.offer(right_min_heap.poll());
    }
    
    public static double findMedian() {
        if(left_max_heap.size()>right_min_heap.size()){
            return left_max_heap.peek();
        }else
            return (left_max_heap.peek()+right_min_heap.peek())/2.0;
    }
    
    public static void main(String args[]){
        MedianFinder obj = new MedianFinder();
        obj.addNum(0);
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(4);;
        obj.addNum(5);
        obj.addNum(8);
        obj.addNum(9);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }   
}
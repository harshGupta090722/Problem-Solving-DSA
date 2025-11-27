import java.util.*;
public class TopKElements {
    
    static class Point implements Comparable<Point>{
        int val;
        int freq;
        
        public Point(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
        
        @Override
        public int compareTo(Point p2){
            return p2.freq-this.freq;
        }
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>();
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            Point p=new Point(entry.getKey(), entry.getValue());
            
            if(pq.size()<k){
                pq.add(p);
            }else if(p.freq> pq.peek().freq){
                pq.poll();
                pq.add(p);
            }
        }

        int idx=0;
        int arr[]=new int[k];
        
        while (k>0 && !pq.isEmpty()) {
            arr[idx]=pq.remove().val;
            k--;
            idx++;
        }

        return arr;
    }
    
    public static void main(String args[]){
        int nums[]={1,2,1,2,1,2,3,1,3,2};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
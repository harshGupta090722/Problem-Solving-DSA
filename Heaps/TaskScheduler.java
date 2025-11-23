import java.util.*;
public class TaskScheduler {
    
    static class Task implements Comparable<Task>{
        int time;
        int count;
        
        public Task(int time,int count){
            this.time=time;
            this.count=count;
        }
        
        @Override
        public int compareTo(Task t2){
            return t2.count-this.count;
        }
    }
    
    public  static int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Task> pq=new PriorityQueue<>();
        
        for(char key:map.keySet()){
            pq.add(new Task(0,map.get(key)));
        }
        
        Queue<Task> q=new LinkedList<>();
        
        int time=0;
        
        
        while(!pq.isEmpty() || !q.isEmpty()){
            
            if(!q.isEmpty() && time-q.peek().time>n){
                pq.add(q.remove());
            }
            
            if(!pq.isEmpty()){
                Task t=pq.remove();
                t.count--;
                t.time=time;
                
                if(t.count>0)
                    q.add(t);
            }
            time++;
        }
        
        return time;
    }
    
    public static void main(String args[]){
        char tasks[]={'A','A','A','B','B','B'};
        int n=2;
        System.out.println(leastInterval(tasks, n));
    }
}
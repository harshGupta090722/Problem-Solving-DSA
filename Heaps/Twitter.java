import java.util.*;

public class Twitter {
    
    HashMap<Integer,List<Tweet>> tweets;
    HashMap<Integer,HashSet<Integer>> follows;
    int time;
    
    class Tweet implements Comparable<Tweet>{
        int id;
        int time;
        
        Tweet(int id,int time){
            this.id=id;
            this.time=time;
        }
        
        @Override
        public int compareTo(Tweet t2){
            return t2.time-this.time;
        }
    }
    
    public Twitter() {
        tweets=new HashMap<>();
        follows=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap=new PriorityQueue<>();
        
        if(tweets.containsKey(userId)){
            for(Tweet t:tweets.get(userId)){
                maxHeap.add(t);
            }
        }
        
        if(follows.containsKey(userId)){
            for(int followeeId:follows.get(userId)){
                if(tweets.containsKey(followeeId)){
                    for(Tweet t:tweets.get(followeeId)){
                        maxHeap.add(t);
                    }
                }
            }
        }
        
        List<Integer> res=new ArrayList<>();
        int count=0;
        while(!maxHeap.isEmpty() && count<10){
            res.add(maxHeap.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId)
            return;
        follows.putIfAbsent(followerId,new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId))
            follows.get(followerId).remove(followeeId);
    }
}
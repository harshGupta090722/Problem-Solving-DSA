//find the maximum number of activities a individual can do.
import java.util.*;
public class ActivitySelection{
    public static void main(String args[]){
        int start[]={1,3,0,5,8,5};
        int end[]  ={2,4,6,7,9,9};
        
        int activities[][]=new int[start.length][3];
        for(int i=0;i<end.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> ans=new ArrayList<>();
        int count=0;
        
        ans.add(activities[0][0]);
        count=1;
        int lastEnd=activities[0][2];
        
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                count++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println(count);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");   
        }
        
    }
    
    /*  end time is sorted
    public static void main(String[] args) {
    int start[]={1,3,0,5,8,5};
    int end[]  ={2,4,6,7,9,9};
    
    int maxAct=0;
    ArrayList<Integer> ans=new ArrayList<>();
    
    maxAct=1;
    ans.add(0);
    
    int lastEnd=end[0];
    for(int i=1;i<end.length;i++){
    if(start[i]>=lastEnd){
    maxAct++;
    ans.add(i);
    lastEnd=end[i];
    }
    }
    System.out.println(maxAct);
    for(int i=0;i<ans.size();i++){
    System.out.print("A"+ans.get(i)+" ");   
    }
    }
    */
}
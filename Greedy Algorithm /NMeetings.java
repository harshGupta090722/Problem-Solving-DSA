import java.util.Arrays;

public class NMeetings {
    
    public static  int maxMeetings(int[] start, int[] end) {
        int n=start.length;
        int Meetings[][]=new int[n][2];
        
        for(int i=0;i<n;i++){
            Meetings[i][0]=start[i];
            Meetings[i][1]=end[i];
        }
        
        Arrays.sort(Meetings,(a,b)->Integer.compare(a[1],b[1]));
        
        int count=1;
        int lastEnd=Meetings[0][1];
        
        for(int i=1;i<n;i++){
            if(Meetings[i][0]>lastEnd){
                count++;
                lastEnd=Meetings[i][1];
            }
        }

        return count;
    }
    public static void main(String args[]){
        int start[]={10,12,20};
        int   end[]={20,25,30};
        System.out.println(maxMeetings(start,end));
    }
}
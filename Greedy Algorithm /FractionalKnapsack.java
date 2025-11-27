import java.util.*;
public class FractionalKnapsack{
    
    public static double fractionalKnapsack(int [] val,int [] wt,long cap){
        int n=val.length;
        double vpw[][]=new double[n][2];
        
        for(int i=0;i<n;i++){
            vpw[i][0]=i;
            vpw[i][1]=(double)val[i]/wt[i]; 
        }
        Arrays.sort(vpw, (a, b) -> Double.compare(b[1], a[1]));

        double maxVal=0;
        
        for(int i=0;i<n;i++){
            int idx=(int)vpw[i][0];

            if(wt[idx]<=cap){
                maxVal+=val[idx];
                cap-=wt[idx];
            }else{
                maxVal+=((double)cap/wt[idx])*val[idx];
                cap=0;
            }
            
            if(cap==0)
                break;
        }
        
        return maxVal;
    }
    
    public static void main (String args[]){
        int val[]={100,60,120};
        int wt[]={20,10,30};
        int cap=50;
        System.out.println(fractionalKnapsack(val, wt, cap));
    }
}
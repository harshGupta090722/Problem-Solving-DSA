//Fractional Knapsack

import java.util.*;
public class FractionalKnapsack {
    
    public static int FractionalKnapsack01(int [] value ,int [] weight,int capacity){
        int n=value.length;
        double ratio[][]=new double[n][2];
        
        for(int i=0;i<n;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int finalVal=0;
        for(int i=n-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            
            if(capacity>=weight[idx]){
                finalVal+=value[idx];
                capacity-=weight[idx];
            }else{
                finalVal+=(ratio[i][1]*capacity);
                capacity=0;
                break; 
            }
        }
        return finalVal;
    }
    
    public static void main(String args[]){
        int[] value={60,100,120};
        int [] weight={10,20,30};
        int capacity=50;
        
        System.out.println(FractionalKnapsack01(value, weight,capacity));
    }   
}
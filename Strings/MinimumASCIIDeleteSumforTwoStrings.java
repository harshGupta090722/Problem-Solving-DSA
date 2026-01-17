//wrong approach -can be solved using dp only !! .Solve it with Dp when you have done DP

import java.util.HashMap;

public class MinimumASCIIDeleteSumforTwoStrings {
    
    public static int minimumDeleteSum(String s1, String s2) {
        int n1=s1.length(),n2=s2.length(),sum=0;
        
        HashMap<Character,Integer> mapS1=new HashMap<>();
        HashMap<Character,Integer> mapS2=new HashMap<>();
        
        for(int i=0;i<n1;i++){
            char ch=s1.charAt(i);
            if(mapS1.containsKey(ch)){
                mapS1.put(ch,mapS1.get(ch)+1);
            }else
                mapS1.put(ch,1);
        }
        
        for(int i=0;i<n2;i++){
            char ch=s2.charAt(i);
            if(mapS2.containsKey(ch)){
                mapS2.put(ch,mapS2.get(ch)+1);
            }else
                mapS2.put(ch,1);
        }
        
        
        for(HashMap.Entry<Character,Integer> entry:mapS1.entrySet()){
            if(!mapS2.containsKey(entry.getKey())){
                sum+=entry.getKey();
            }else if(mapS2.containsKey(entry.getKey()) && !entry.getValue().equals(mapS2.get(entry.getKey())) && entry.getValue()>mapS2.get(entry.getKey())){
                sum+=(entry.getValue()-mapS2.get(entry.getKey()))*entry.getKey();
            }
        }
        
        for(HashMap.Entry<Character,Integer> entry:mapS2.entrySet()){
            if(!mapS1.containsKey(entry.getKey())){
                sum+=entry.getKey();
            }else if(mapS1.containsKey(entry.getKey()) && !entry.getValue().equals(mapS1.get(entry.getKey())) && entry.getValue()>mapS1.get(entry.getKey())){
                sum+=(Math.abs(entry.getValue()-mapS1.get(entry.getKey())))*entry.getKey();
            }
        }
        
        return sum;
    }
    public static void main(String args[]){
        String s1="delete",s2="leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}
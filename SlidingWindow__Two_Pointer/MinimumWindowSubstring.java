import java.util.*;
public class MinimumWindowSubstring{
    
    public static String minWindow(String s, String t) {
        if(s==null || t==null)
            return "";

        int m=s.length(),n=t.length();
        if(n>m)
            return "";

        HashMap<Character,Integer> need=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            need.put(ch,need.getOrDefault(ch, 0)+1);
        }
        
        HashMap<Character,Integer> window=new HashMap<>();
        int required=need.size();
        int formed=0;
        
        int left=0,right=0;
        int bestLeft=0,bestLen=Integer.MAX_VALUE;
        
        while(right<s.length()){
            char ch=s.charAt(right);
            
            window.put(ch,window.getOrDefault(ch, 0)+1);
            
            if(need.containsKey(ch) && window.get(ch).intValue()==need.get(ch).intValue()){
                formed++;
            }
            
            while(left<=right && formed==required){
                int windowLen=right-left+1;
                if(windowLen<bestLen){
                    bestLen=windowLen;
                    bestLeft=left;
                }
                
                char leftChar=s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                
                if(need.containsKey(leftChar) && window.get(leftChar).intValue()<need.get(leftChar).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return bestLen==Integer.MAX_VALUE?"":s.substring(bestLeft,bestLeft+bestLen);
    }
    
    public static void main(String args[]){
        String s="ADOBECODEBANC";
        String t="ABC"; 
        System.out.println(minWindow(s, t));
    }
}
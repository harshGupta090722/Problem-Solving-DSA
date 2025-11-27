import java.util.Arrays;

public class AssignCookies {
    
    public static int findContentChildren( int[] g,int[] s) {
        int n1 = s.length, n2 = g.length;
        
        if (n1 == 0)
            return 0;
        
        Arrays.sort(s);
        Arrays.sort(g);
        
        int count = 0;

        int p1=0,p2=0;

        while(p2<n2 && p1<n1){
            while(p1<n1 && s[p1]<g[p2]){
                p1++;
            }

            if (p1 == n1) break; 

            if(s[p1]>=g[p2]){
                p2++;
                p1++;
                count++;
            }
        }

        return count;
    }
    
    public static void main(String args[]){
        int g[]={1,2,3};
        int s[]={1,1};
        System.out.println(findContentChildren(g, s));  
    }
}
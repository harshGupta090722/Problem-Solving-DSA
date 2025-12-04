public class Candy {
    
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=1;
        right[n-1]=1;
        
        
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        
        for(int i=n-1;i>0;i--){
            if(ratings[i-1]>ratings[i])
                right[i-1]=right[i]+1;
            else
                right[i-1]=1;
        }
        
        
        int count=0;
        for(int i=0;i<n;i++){
            count+=Math.max(left[i],right[i]);    
        }
        
        return count;
    }
    public static void main(String args[]){
        int ratings[]={0,2,4,3,2,1,1,3,5,6,4,0,0};
        System.out.println(candy(ratings));
    }
}
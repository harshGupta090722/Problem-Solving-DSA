class FourDivisors{
    
    public static int sumFourDivisors(int[] nums) {
        int sum=0;
        for (int i:nums) {
            sum+=hasExactly4divisors(i);
        }
        return sum;
    }
    
    public static int hasExactly4divisors(int n) {
        int count=0;
        int sum=0;
        
        for(int i=1;i*i<=n;i++){
            
            if(n%i==0){
                int d1=i;
                int d2=n/i;
                
                if(d1==d2){
                    count++;
                    sum+=d1;
                }else{
                    count+=2;
                    sum+=d1+d2;
                }
                
                if(count>4)
                    return 0;
            }
        }
        
        return count==4?sum:0;
    }
    public static void main(String args[]){
        int nums[]={21,4,7};
        System.out.println(sumFourDivisors(nums));
    }
}
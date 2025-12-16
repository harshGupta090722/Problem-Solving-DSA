public class NumberOfSmoothDecentPeriodsOfStacks {
    public static long getDescentPeriods(int[] prices) {
        long ans = 1, curr = 1;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1)
                curr++;
            else
                curr = 1;
            ans += curr;
        }
        return ans;
    }
    public static void main(String args[]){
        int prices[]={3,2,1,4};
        System.out.println(getDescentPeriods(prices));
    }
}
import java.util.*;
//This is wrong solution ,Greedy won't always solve this question .It can only be solved by DP .
public class MinimumCoins {
    
    public static int minimumCoins(Integer[] coins, int amount) {
        Arrays.sort(coins,Collections.reverseOrder());
        
        int remainig_amount=amount;
        int total_coins=0;
        for(int i=0;i<coins.length;i++){
            
            if(remainig_amount>=coins[i]){
                int coins_required=remainig_amount/coins[i];
                total_coins+=coins_required;
                remainig_amount-=(coins_required*coins[i]);
            }

        }
        if(remainig_amount>0)
            return -1;

        return total_coins;
    }
    public static void main(String args[]){
        Integer []coins={1,3,4};
        int amount=6;
        System.out.println(minimumCoins(coins, amount));
    }   
}
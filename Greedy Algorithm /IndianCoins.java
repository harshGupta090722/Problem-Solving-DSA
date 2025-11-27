/* 
We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000].
Find min no. of coins/notes to make change for a Value V.
*/ 
import java.util.*; 
public class IndianCoins {
    
    public static void main(String args[]){
        Integer avalcoins[]={1,2,5,10,20,50,100,500,2000};
        
        Arrays.sort(avalcoins,Collections.reverseOrder());
        
        int countofCoins=0;
        int amount=590;
        
        ArrayList<Integer> coins=new ArrayList<>();
        int idx=0;
        
        while(amount>0 && idx<avalcoins.length){
            while(avalcoins[idx]<=amount){
                countofCoins++;
                coins.add(avalcoins[idx]);
                amount-=avalcoins[idx];
            }
            idx++;
        }
        
        System.out.println("No of coins needed ="+countofCoins);
        System.out.println("List of Coins "+coins);
    }
    
}
public class LemonadeChanges {
    
    public static boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        
        for(int bill:bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five==0)
                    return false;
                five--;
                ten++;
            }else{
                if(five>0 && ten>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                }else 
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        int bills[]={5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(bills));
    }
}
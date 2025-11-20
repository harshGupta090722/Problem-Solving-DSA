import java.util.*;
public class WeakestSoldier {
    static class SoldierRow implements Comparable<SoldierRow>{
        int soldierCount;
        int idx;
        
        public SoldierRow(int soldierCount,int idx){
            this.soldierCount=soldierCount;
            this.idx=idx;
        }
        
        @Override
        public int compareTo(SoldierRow s2){
            if(this.soldierCount!=s2.soldierCount)
                return this.soldierCount-s2.soldierCount;
            
            return this.idx-s2.idx;
        }
    }
    
    public static void main(String args[]){
        int k=2;
        int mat[][]={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}};
            
            PriorityQueue<SoldierRow> pq=new PriorityQueue<>();
            
            for(int i=0;i<4;i++){
                int soldierCount=0;
                for(int j=0;j<4;j++){ 
                    if(mat[i][j]==1)
                        soldierCount++;
                    else
                        break;
                }
                pq.add(new SoldierRow(soldierCount, i)); 
            } 
            
            for(int i=0;i<k;i++){
                System.out.println("R"+pq.remove().idx);
            }
            
        }   
    }
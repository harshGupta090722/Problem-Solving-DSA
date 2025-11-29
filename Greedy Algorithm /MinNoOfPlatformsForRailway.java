import java.util.*;
public class MinNoOfPlatformsForRailway {
    static class Train{
        int arr;
        int dep;
        
        public Train(int arr,int dep){
            this.arr=arr;
            this.dep=dep;
        }
    }
    public static int findPlatform(int[] Arrival, int[] Departure) {
        int n=Arrival.length;
        
        Train trains[]=new Train[n];
        
        for(int i=0;i<n;i++){
            trains[i]=new Train(Arrival[i], Departure[i]);
        }
        
        Arrays.sort(trains,(a,b)->Integer.compare(a.arr, b.arr));
        
        List<Integer> platformDep=new ArrayList<>();
        
        for(Train t:trains){
            int A=t.arr;
            int D=t.dep;
            
            int bestPlaformIdx=-1;
            int bestDepTime=-1;
            
            for(int i=0;i<platformDep.size();i++){
                int lastDep=platformDep.get(i);
                
                if(lastDep<A && lastDep>bestDepTime){
                    bestDepTime=lastDep;
                    bestPlaformIdx=i;
                }
            }
            if(bestPlaformIdx==-1){
                platformDep.add(D);
            }else{
                platformDep.set(bestPlaformIdx,D);
            }
        }
        return platformDep.size();
    }
    public static void main(String args[]){
        int   Arrival[]={900,940,950,1100,1500,1800};
        int Departure[]={910,1200,1120,1130,1900,2000};
        System.out.println(findPlatform(Arrival, Departure));
    }
}
public class FindTheLargestAreaOfSquareInsideTwoRectangles {
    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int row=bottomLeft.length;
        long maxSide=0;
        
        for(int i=0;i<row;i++){
            for(int j=i+1;j<row;j++){
                
                int overLapX=Math.min(topRight[i][0],topRight[j][0])-Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                
                int overLapY=Math.min(topRight[i][1],topRight[j][1])-Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                
                
                if(overLapX>0 && overLapY>0){
                    long side=Math.min(overLapX,overLapY);
                    maxSide=Math.max(maxSide, side);
                }
            }
        }
        
        return maxSide*maxSide;
    }
    
    public static void main(String args[]){
        int bottomLeft[][]={{1,1},
        {2,2},
        {1,2}};
        
        int topRight[][]={{3,3},
        {4,4},
        {3,4}};
        
        System.out.println(largestSquareArea(bottomLeft, topRight));
    }
}
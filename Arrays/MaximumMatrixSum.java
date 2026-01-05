public class MaximumMatrixSum {
    
    public static long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int minAbs=Integer.MAX_VALUE,numberOfNegativeNumber=0;
        
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val=matrix[i][j];
                
                if(val<0)
                    numberOfNegativeNumber++;
                
                int absVal=Math.abs(val);
                sum+=absVal;
                
                minAbs=Math.min(minAbs,absVal);
            }
        }
        
        if(numberOfNegativeNumber%2!=0)
            sum=sum-2L*minAbs;
        return sum;
    }
    public static void main(String args[]){
        int matrix[][]={{-1,0,-1},
        {-2,1,3},
        {3,2,2}};
        System.out.println(maxMatrixSum(matrix));
    }   
} 
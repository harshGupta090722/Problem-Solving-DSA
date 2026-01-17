public class SeparateSquaresI {
    
    public static double separateSquares(int[][] squares) {
        
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l;
        }

        double halfArea = totalArea / 2.0;

        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double below = areaBelow(squares, mid);

            if (below < halfArea) {
                low = mid;    
            } else {
                high = mid;  
            }
        }

        return low;
    }

    private static double areaBelow(int[][] squares, double h) {
        double area = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            double heightBelow = Math.max(0, Math.min(l, h - y));
            area += heightBelow * l;
        }

        return area;
    }
    public static void main(String args[]){
        int squares[][]={{0,0,1},{2,2,1}};
        System.out.println(separateSquares(squares));
    }
}
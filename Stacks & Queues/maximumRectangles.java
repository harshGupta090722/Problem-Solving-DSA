public class maximumRectangles {
    public static int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        
        

    }

    public static void main(String args[]) {
        char matrix[][] = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
    }
}
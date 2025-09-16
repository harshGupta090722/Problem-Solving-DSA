public class row_wth_max_1 {
    public static int rowWithMax1s(int[][] mat) {
        int down = 0, left = mat[0].length - 1, rowWithMax = -1;
        while (down < mat.length && left >= 0) {
            if (mat[down][left] == 1) {
                rowWithMax = down;
                left--;
            } else
                down++;
        }
        return rowWithMax;
    }

    public static void main(String args[]) {
        //int mat[][] = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
         int mat[][] = { { 0, 0},{ 0, 0 }};

        System.out.println(rowWithMax1s(mat));
    }
}
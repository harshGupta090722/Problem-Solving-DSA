import java.util.*;

public class spiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, right = col - 1, bottom = row - 1, left = 0, top = 0,
                count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (count <= row * col) {

            // right
            for (int j = left; j <= right && count <= row * col; j++) {
                list.add(matrix[top][j]);
                count++;
            }
            top++;

            // down
            for (int i = top; i <= bottom && count <= row * col; i++) {
                list.add(matrix[i][right]);
                count++;
            }
            right--;

            // left
            for (int j = right; j >= left && count <= row * col; j--) {
                list.add(matrix[bottom][j]);
                count++;
            }
            bottom--;

            // up
            for (int i = bottom; i >= top && count <= row * col; i--) {
                list.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return list;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 },
                           { 4, 5, 6 },
                           { 7, 8, 9 } };
        System.out.println(spiralOrder(matrix));
    }
}
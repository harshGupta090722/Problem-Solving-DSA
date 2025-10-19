import java.util.*;

public class Rat_In_A_Maze {
    public static List<String> findPath(int[][] grid) {
        List<String> paths = new ArrayList<>();
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        backtrack(grid, paths, new StringBuilder(), 0, 0, visited);
        return paths;
    }

    public static void backtrack(int[][] grid, List<String> paths, StringBuilder path, int row, int col,
            boolean visited[][]) {
        if (row == grid.length - 1 && col == grid.length - 1) {
            paths.add(path.toString());
            return;
        }
        if (row < 0 || col < 0 || row >= grid.length || col >= grid.length || visited[row][col] == true
                || grid[row][col] == 0)
            return;

        visited[row][col] = true;

        // down
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            path.append('D');
            backtrack(grid, paths, path, row + 1, col, visited);
            path.deleteCharAt(path.length() - 1);
        }

        // right
        if (col + 1 < grid.length && grid[row][col + 1] == 1) {
            path.append('R');
            backtrack(grid, paths, path, row, col + 1, visited);
            path.deleteCharAt(path.length() - 1);
        }

        // up
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            path.append('U');
            backtrack(grid, paths, path, row - 1, col, visited);
            path.deleteCharAt(path.length() - 1);
        }

        // left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            path.append('L');
            backtrack(grid, paths, path, row, col - 1, visited);
            path.deleteCharAt(path.length() - 1);
        }

        visited[row][col] = false;
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        System.out.println(findPath(grid));
    }
}
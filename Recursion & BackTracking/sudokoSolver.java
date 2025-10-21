public class sudokoSolver {
    public static boolean solveSudoku(char[][] board) {
        return backtrack(board, 0, 0);
    }

    public static boolean backtrack(char board[][], int row, int col) {
        if (row == board.length)
            return true;
        if (col == board.length)
            return backtrack(board, row + 1, 0);

        if (board[row][col] != '.')
            return backtrack(board, row, col + 1);

        for (int num = 1; num <= 9; num++) {
            char ch = (char) (num + '0');
            if (isSafe(board, row, col, ch)) {
                board[row][col] = ch;
                if (backtrack(board, row, col + 1))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col, char ch) {
        for (int i = 0; i < 9; i++) { // check row & col wise
            if (board[row][i] == ch || board[i][col] == ch)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        char board[][] = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        solveSudoku(board);
        printBoard(board);
    }
}
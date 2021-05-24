import java.util.*;

public class SudokuSolver {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {

        // checking in row
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == num)
                return false;
        }

        // checking for col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }

        int rsp = (row / 3) * 3;
        int csp = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rsp + i][csp + j] == num)
                    return false;
            }
        }
        return true;
    }

    public static void solveSudoku(int[][] board, int i, int j) {

        if (i == board.length) {
            display(board);
            return;
        }

        int nr = 0;
        int nc = 0;
        if (j == board[0].length - 1) {
            nr = i + 1;
            nc = 0;
        } else {
            nr = i;
            nc = j + 1;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, nr, nc);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isValid(board, i, j, num)) {
                    board[i][j] = num;
                    solveSudoku(board, nr, nc);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
        scn.close();
    }
}

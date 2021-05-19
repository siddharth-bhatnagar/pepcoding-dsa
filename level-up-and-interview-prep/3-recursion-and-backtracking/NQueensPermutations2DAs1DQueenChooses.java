import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // row
        for (int j = 0; j < chess[0].length; j++) {
            if (chess[row][j] != 0)
                return false;
        }

        // col
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] != 0)
                return false;
        }

        // diagonals
        for (int i = row + 1, j = col + 1; i < chess.length && j < chess[0].length; i++, j++) {
            if (chess[i][j] != 0)
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] != 0)
                return false;
        }
        for (int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] != 0)
                return false;
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            for (int i = 0; i < tq; i++) {
                for (int j = 0; j < tq; j++) {
                    if (chess[i][j] != 0) {
                        System.out.print("q" + chess[i][j] + "\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int cell = 0; cell < tq * tq; cell++) {
            int row = cell / chess[0].length;
            int col = cell % chess[0].length;
            if (chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
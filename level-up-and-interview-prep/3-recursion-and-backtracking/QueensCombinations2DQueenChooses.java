import java.io.*;
import java.util.*;

public class QueensCombinations2DQueenChooses {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j) {
        // write your code here
        if(qpsf == tq) {
            for(int row=0;row<chess.length;row++) {
                for(int col=0;col<chess[0].length;col++) {
                    if(chess[row][col] == false) {
                        System.out.print("-\t");
                    }
                    else {
                        System.out.print("q\t");
                    }
                }
                System.out.println();
            }

            System.out.println();
            return;
        }

        for (int k = j + 1; k < tq; k++) {
            chess[i][k] = true;
            queensCombinations(qpsf + 1, tq, chess, i, k);
            chess[i][k] = false;
        }

        for (int row = i + 1; row < tq; row++) {
            for (int k = 0; k < tq; k++) {
                chess[row][k] = true;
                queensCombinations(qpsf + 1, tq, chess, row, k);
                chess[row][k] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, 0, -1);
    }
}
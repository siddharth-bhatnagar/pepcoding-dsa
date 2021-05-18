import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        // write your code here
        if(row == tq) {
            if(qpsf == tq) {
                System.out.println(asf);
            }

            return;
        }


        int nextRow = row;
        int nextCol = col;
        String YES = asf;
        String NO = asf;
        if (col == tq - 1) {
            nextRow++;
            nextCol = 0;
            YES = YES + "q\n";
            NO = NO + "-\n";
        } else {
            nextCol++;
            YES = YES + "q";
            NO = NO + "-";
        }

        queensCombinations(qpsf + 1, tq, nextRow, nextCol, YES);
        queensCombinations(qpsf, tq, nextRow, nextCol, NO);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
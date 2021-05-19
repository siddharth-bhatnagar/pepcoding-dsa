import java.io.*;
import java.util.*;

public class QueensCombinations2DBoxChooses {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queenCombinations(0, n, 0, 0, "");
    }

    public static void queenCombinations(int qpsf, int tq, int row, int col, String asf) {
        
        if(row == tq) {
            if(qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }
        
        int nr = row, nc = col;
        String yasf = asf, nasf = asf;

        if(col == tq - 1) {
            nr += 1;
            nc = 0;
            yasf = yasf + "q\n";
            nasf = nasf + "-\n";
        }
        else {
            nc += 1;
            yasf = yasf + "q";
            nasf = nasf + "-";
        }
        
        queenCombinations(qpsf + 1, tq, nr, nc, yasf);
        queenCombinations(qpsf, tq, nr,nc, nasf);
    }
}

/**
 * Upon observation, it is realised that this is Combination problem as queens are identical
 * Approach -- Box will choose which queen to take
 * Each box has two choices
 */
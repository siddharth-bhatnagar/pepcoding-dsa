import java.io.*;
import java.util.*;

public class PermutationsTwo {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
        scn.close();
    }

    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {

        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        for (int i = 0; i < ts; i++) {
            if (items[i] == 0) {
                items[i] = 1;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                items[i] = 0;
            }
        }
        permutations(cb + 1, tb, items, ssf, ts, asf + 0);
    }
}

/**
 * There are r distinct items to be placed in n boxes, we want to find all
 * permutations Approach -- Box chooses item So each box has an option to not
 * select any item or select any one of the items. nPr = nCr * r!
 */
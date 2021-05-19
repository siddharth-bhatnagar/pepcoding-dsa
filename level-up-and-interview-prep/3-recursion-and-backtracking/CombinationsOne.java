import java.io.*;
import java.util.*;

public class CombinationsOne {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        combinations(1, nboxes, 0, ritems, "");
        scn.close();
    }

    public static void combinations(int cb, int tb, int ssf, int ts, String asf) {

        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        combinations(cb + 1, tb, ssf, ts, asf + "-");
    }
}

/**
 * There are r identical items, therefore, we only want to select the boxes and not find their arrangments
 * Approach -- Box chooses Item
 * All the boxes have only two choices, either select an item or select no items
 * Since, we want to find combination
 * nCr = (n!)/(r!*(n-r)!)
 * We will express the choices of all boxes and print only those choices in which number of items is equal to total given items
 * 2^n = nC0 + nC1 + nC2 +......+ nCn
 *  
 */
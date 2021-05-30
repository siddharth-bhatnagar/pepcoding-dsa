import java.util.*;

public class CombinationsTwo {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        combinations(new boolean[nboxes], 1, ritems, -1);
        scn.close();
    }

    public static void combinations(boolean[] boxes, int ci, int ti, int lb) {
        
        if(ci > ti) {
            for(int i=0;i<boxes.length;i++) {
                if(boxes[i] == true) {
                    System.out.print("i");
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        // lb - last box
        for(int i=lb+1;i<boxes.length;i++) {
            // if(boxes[i] == false) {
                boxes[i] = true;
                combinations(boxes, ci + 1, ti, i);
                boxes[i] = false;
            // }
        }
    }
}

/**
 * There are r identical items to be placed in n boxes. Approach -- item chooses
 * box Item will only choose that box in which the r-label of items is
 * increasing otherwise we will have duplicate configs in ans. nCr = nPr/r!
 */
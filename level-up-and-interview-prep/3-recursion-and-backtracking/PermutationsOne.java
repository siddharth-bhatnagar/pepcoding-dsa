import java.util.*;

public class PermutationsOne {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        permutations(new int[nboxes], 1, ritems);
        scn.close();
    }

    public static void permutations(int[] boxes, int ci, int ti) {

        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }
}

/**
 * Since, we have distinct items, we need to permute. Approach -- Item chooses
 * which box to go in. Items have choices as n*(n-1)*(n-2)*(n-3)*.....*(n-r-1)
 * The above expression means item 1 has n choices, item 2 has n-1 choices and
 * so on... This expression is equal to nPr = (n!)/(n-r)!
 */
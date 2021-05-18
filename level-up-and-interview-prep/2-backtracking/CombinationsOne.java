import java.io.*;
import java.util.*;

public class Main {

    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        // write your code here
        int n = boxes.length;
        if(ci == ti + 1) {
            for(int item: boxes) {
                if(item == 0) System.out.print("-");
                else System.out.print("i");
            }

            System.out.println();
            return;
        }

        for(int i=lb+1;i<n;i++) {
            if(boxes[i] == 0) {
                boxes[i] = 1;
                combinations(boxes, ci+1, ti, i);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
    }

}

// lb - last box: index of the previously placed item;
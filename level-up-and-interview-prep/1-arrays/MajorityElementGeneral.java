import java.io.*;
import java.util.*;

public class MajorityElementGeneral {

    // Making a class of type Pair for processing potential candidates for majority
    public static class Pair {
        int e;
        int c;

        public Pair(int e, int c) {
            this.e = e;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        // Array of type Pair
        // There can be at most k-1 potential candidates mathematically
        // Step 1:
        Pair[] temp = new Pair[k - 1];
        for (int i = 0; i < temp.length; i++) {
            // Initializing the array - O(k) operation
            temp[i] = new Pair(0, 0);
        }

        // Step 2:
        // Finding Potential Candidates
        for (int i = 0; i < arr.length; i++) {
            int candidate = arr[i];
            int j;
            // traversing through temp
            for (j = 0; j < temp.length; j++) {
                if (candidate == temp[j].e) {
                    temp[j].c++;
                    break;
                }
            }

            if (j == k - 1) {
                int l;

                for (l = 0; l < temp.length; l++) {
                    if (temp[l].c == 0) {
                        temp[l].e = candidate;
                        temp[l].c = 1;
                        break;
                    }
                }

                if (l == k - 1) {
                    for (l = 0; l < k - 1; l++) {
                        temp[l].c--;
                    }
                }
            }
        }

        // After Step 2, temp has potential candidates for majority
        // Step 3: Verification
        for (int i = 0; i < temp.length; i++) {
            int freq = 0;
            for (int num : arr) {
                if (num == temp[i].e) {
                    freq++;
                }
            }

            if (freq > n / k) {
                System.out.print(temp[i].e + " ");
            }
        }

        // Closing input stream
        scn.close();
    }
}
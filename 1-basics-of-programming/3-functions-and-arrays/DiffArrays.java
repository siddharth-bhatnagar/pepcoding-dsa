import java.io.*;
import java.util.*;

public class DiffArrays {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int a1[] = new int[n1];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int a2[] = new int[n2];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }

        int result[] = getDiffOfArrays(a1, a2, n1, n2);
        int idx = 0;
        while (idx < result.length) {
            if (result[idx] == 0) {
                idx++;
            } else {
                break;
            }
        }

        for (int i = idx; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] getDiffOfArrays(int a1[], int a2[], int n1, int n2) {
        int i = n1 - 1;
        int j = n2 - 1;
        int[] diff = new int[n2];
        int k = diff.length - 1;
        int c = 0;
        while (k >= 0) {
            int d = c + a2[j];
            if (i >= 0) {
                d -= a1[i];
            }
            if (d < 0) {
                d = d + 10;
                c = -1;
            } else {
                c = 0;
            }
            diff[k] = d;
            i--;
            j--;
            k--;
        }
        return diff;
    }
}
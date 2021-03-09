import java.io.*;
import java.util.*;

public class SumArrays {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int a[] = new int[n1];

        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int b[] = new int[n2];

        for (int i = 0; i < b.length; i++) {
            b[i] = scn.nextInt();
        }

        sumArrays(a, b);
    }

    public static void sumArrays(int a[], int b[]) {
        int i = a.length - 1;
        int j = b.length - 1;
        int[] sum = new int[Math.max(i + 1, j + 1)];
        int k = sum.length - 1;
        int c = 0;
        while (k >= 0 || c > 0) {
            int d = c;
            if (i >= 0) {
                d += a[i];
            }
            if (j >= 0) {
                d += b[j];
            }

            c = d / 10;
            d = d % 10;
            sum[k] = d;

            k--;
            j--;
            i--;
        }
        for (int m = 0; m < sum.length; m++) {
            System.out.println(sum[m]);
        }
    }
}
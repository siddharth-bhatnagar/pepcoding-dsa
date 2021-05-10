/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        try {
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();
            while (t-- > 0) {
                int n = scn.nextInt();
                int m = scn.nextInt();

                int a[] = new int[n];
                int b[] = new int[m];
                int s1 = 0, s2 = 0;
                for (int i = 0; i < n; i++) {
                    a[i] = scn.nextInt();
                    s1 += a[i];
                }

                for (int i = 0; i < m; i++) {
                    b[i] = scn.nextInt();
                    s2 += b[i];
                }

                if (s1 != s2) {
                    System.out.println("Alice");
                    continue;
                }

                Arrays.sort(a);
                Arrays.sort(b);

                int i = 0, j = 0;
                while (i < n && a[i] == 0)
                    i++;
                while (j < m && b[j] == 0)
                    j++;

                while (i < n && j < m) {
                    if (a[i] != b[j]) {
                        break;
                    }
                    i++;
                    j++;
                }

                if (i == n && j == m)
                    System.out.println("Bob");
                else
                    System.out.println("Alice");

            }
        } catch (Exception e) {
            return;
        }
    }
}

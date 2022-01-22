import java.io.*;
import java.util.*;

public class ChefAndSecretPassword {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            String s = scn.next();
            String pwd = guessPassword(s, n);
            System.out.println(pwd);
        }
        scn.close();
    }

    private static String guessPassword(String s, int n) {
        if (n == 1)
            return s;
        int[] z = zFunc(s, n);
        int len = s.length();

        for (int val : z) {
            if (val > 0 && val < len) {
                len = val;
            }
        }

        return s.substring(0, len);
    }

    private static int[] zFunc(String s, int n) {
        int[] z = new int[n];
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i <= R) {
                z[i] = Math.min(z[i - L], R - i + 1);
            }

            while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > R) {
                L = i;
                R = i + z[i] - 1;
            }
        }

        return z;
    }
}
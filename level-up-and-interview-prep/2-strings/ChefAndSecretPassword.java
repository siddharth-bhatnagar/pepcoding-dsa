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
        int[] z = zFunc(s);
        int len = s.length();

        for (int val : z) {
            if (val > 0 && val < len) {
                len = val;
            }
        }

        return s.substring(0, len);
    }

    private static int[] zFunc(String str) {
        int n = str.length();
        int[] z = new int[n];

        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            // Giving headstart
            if (i <= R) {
                z[i] = Math.min(z[i - L], R - i + 1);
            }

            // Updating/Trying to extend substring and prefix
            while (i + z[i] < n && str.charAt(i + z[i]) == str.charAt(z[i])) {
                z[i]++;
            }

            // Updating bubble boundary
            if (i + z[i] - 1 > R) {
                L = i;
                R = i + z[i] - 1;
            }
        }

        return z;
    }
}
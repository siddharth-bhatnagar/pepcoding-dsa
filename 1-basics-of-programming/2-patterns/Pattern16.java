import java.util.*;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nsp = n * 2 - 3;
        int nst = 1;

        for (int i = 1; i <= n; i++) {
            int val = 1;
            int x = i;
            for (int j = 1; j <= nst; j++) {
                System.out.print(val + "	");
                val++;
            }

            for (int j = 1; j <= nsp; j++) {
                System.out.print("	");
            }

            if (i < n) {

                for (int j = 1; j <= nst; j++) {
                    System.out.print(x + "	");
                    x--;
                }
            } else {
                x = x - 1;
                for (int j = 1; j < nst; j++) {
                    System.out.print(x + "	");
                    x--;
                }

            }
            nsp -= 2;
            nst++;
            System.out.println();
        }
    }
}
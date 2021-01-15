import java.util.*;

public class Pattern9 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nsp1 = 0;
        int nst = 1;
        int nsp2 = n - 2;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= nsp1; j++) {
                System.out.print("	");
            }

            for (int j = 1; j <= nst; j++) {
                System.out.print("*	");
            }

            for (int j = 1; j <= nsp2; j++) {
                System.out.print("	");
            }

            if (i != n / 2 + 1) {
                for (int j = 1; j <= nst; j++) {
                    System.out.print("*	");
                }
            }

            if (i <= n / 2) {
                nsp1++;
                nsp2 -= 2;
            } else {
                nsp1--;
                nsp2 += 2;
            }
            System.out.println();
        }
    }
}
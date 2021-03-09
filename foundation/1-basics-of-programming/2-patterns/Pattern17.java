import java.util.*;

public class Pattern17 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nsp = n / 2;
        int nst = 1;

        for (int i = 1; i <= n; i++) {

            if (i != n / 2 + 1) {

                for (int j = 1; j <= nsp; j++) {
                    System.out.print("	");
                }

                for (int j = 1; j <= nst; j++) {
                    System.out.print("*	");
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    System.out.print("*	");
                }
            }

            if (i <= n / 2) {
                nst++;
            } else {
                nst--;
            }
            System.out.println();
        }
    }
}
import java.util.*;

public class Pattern8 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nsp = n - 1;
        int nst = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= nsp; j++) {
                System.out.print("	");
            }

            for (int j = 1; j <= nst; j++) {
                System.out.print("*	");
            }

            nsp--;
            System.out.println();
        }

    }
}
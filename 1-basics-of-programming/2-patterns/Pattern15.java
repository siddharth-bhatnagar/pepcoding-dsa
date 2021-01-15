import java.util.*;

public class Pattern15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nsp = n / 2;
        int val = 1;
        int nst = 1;

        for (int i = 1; i <= n; i++) {
            int xval = val;
            for (int j = 1; j <= nsp; j++) {
                System.out.print("	");
            }

            for (int j = 1; j <= nst; j++) {
                System.out.print(xval + "	");
                if (j <= nst / 2) {
                    xval++;
                } else {
                    xval--;
                }
            }

            if (i <= n / 2) {
                nsp--;
                nst += 2;
                val++;
            } else {
                val--;
                nsp++;
                nst -= 2;
            }
            System.out.println();
        }

    }
}
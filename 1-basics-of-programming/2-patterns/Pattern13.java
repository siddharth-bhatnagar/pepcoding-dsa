import java.util.*;

public class Pattern13 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int iCj = 1;
            for (int j = 0; j <= i; j++) {

                System.out.print(iCj + "	");
                int iCjplus1 = iCj * (i - j) / (j + 1);
                iCj = iCjplus1;
            }
            System.out.println();
        }
    }
}
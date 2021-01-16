import java.util.*;

public class Pattern10 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {

        int nst = 1;
        int nsp1 = n / 2;
        int nsp2 = 1;

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= nsp1; k++) {
                System.out.print("\t");
            }

            for (int j = 1; j <= nst; j++) {
                System.out.print("*\t");
            }

            if (i > 1 && i < n) {

                for (int k = 1; k <= nsp2; k++) {
                    System.out.print("\t");
                }

                for (int j = 1; j <= nst; j++) {
                    System.out.print("*\t");
                }
            }

            if (i <= n / 2) {
                nsp1--;
                if (i > 1)
                    nsp2 += 2;
            } else {
                nsp1++;
                if (i < n)
                    nsp2 -= 2;
            }

            System.out.println();
        }
    }
}



//  		*	
// 	    *		*	
//  *				*	
// 	    *		*	
// 		    *	














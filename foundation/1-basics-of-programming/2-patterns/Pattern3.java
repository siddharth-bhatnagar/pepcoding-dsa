import java.util.*;

public class Pattern3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {

        int nst = 1;
        int nsp = n - 1;

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= nsp; k++) {
                System.out.print("\t");
            }
            nsp--;

            for (int j = 1; j <= nst; j++) {
                System.out.print("*\t");
            }
            nst++;

            System.out.println();
        }
    }
}

//     			    *	
//     		    *	*	
//     	    *	*	*	
//     *	*	*	*	
// *	*	*	*	*	

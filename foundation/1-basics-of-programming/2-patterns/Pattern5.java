import java.util.*;

public class Pattern5 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {

        int nst = 1;
        int nsp = n / 2;

        for (int i = 1; i <= n; i++) { // loop to control rows

            for (int k = 1; k <= nsp; k++) { // controls spaces
                System.out.print("\t");
            }

            for (int j = 1; j <= nst; j++) { // controls stars
                System.out.print("*\t");
            }

            // updation of stars and spaces before changing row
            if (i <= n / 2) {
                nsp--;
                nst += 2;
            } else {
                nsp++;
                nst -= 2;
            }
            // changing line in console
            System.out.println();
        }
    }
}


// 		    *	
// 	    *	*	*	
// *	*	*	*	*	
// 	    *	*	*	
// 		    *	

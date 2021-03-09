import java.util.*;

public class Pattern6 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {

        int nst = (n / 2) + 1;
        int nsp = 1;

        for (int i = 1; i <= n; i++) { // loop to control rows

            for (int k = 1; k <= nst; k++) { // controls stars
                System.out.print("*\t");
            }

            for (int j = 1; j <= nsp; j++) { // controls spaces
                System.out.print("\t");
            }

            for (int k = 1; k <= nst; k++) { // controls stars
                System.out.print("*\t");
            }

            // updation of stars and spaces before changing row
            if (i <= n / 2) {
                nsp += 2;
                nst--;
            } else {
                nsp -= 2;
                nst++;
            }
            // changing line in console
            System.out.println();
        }
    }
}

// *	*	*		*	*	*	
// *	*				*	*	
// *						*	
// *	*				*	*	
// *	*	*		*	*	*	

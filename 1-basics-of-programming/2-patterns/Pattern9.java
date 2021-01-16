import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {
        int nst = 1;
        int nsp1 = 0;
        int nsp2 = n - 2;
        for (int i = 1; i <= n; i++) { // controls rows

            for (int j = 1; j <= nsp1; j++) { // controls spaces 1
                System.out.print("\t");
            }

            for (int j = 1; j <= nst; j++) { // controls stars 1
                System.out.print("*\t");
            }

            for (int j = 1; j <= nsp2; j++) { // controls spaces 2
                System.out.print("\t");
            }
            if (i != (n / 2) + 1) {
                for (int j = 1; j <= nst; j++) { // controls stars 2
                    System.out.print("*\t");
                }
            }


            if (i <= n / 2) { // updations to stars and spaces in each row
                nsp1++;
                nsp2 -= 2;
            } else {
                nsp1--;
                nsp2 += 2;
            }
            // changing line in console
            System.out.println();
        }
    }
}



// *				*	
// 	    *		*		
// 	    	*			
// 	    *		*		
// *				*	

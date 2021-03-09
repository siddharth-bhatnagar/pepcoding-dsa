import java.util.*;

public class Pattern1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method1(n);
        method2(n);
    }

    public static void method1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void method2(int n) {
        int nst = 1;
        int nsp = n - 1;
        for (int i = 1; i <= n; i++) { // this loop controls the rows

            for (int j = 1; j <= nst; j++) { // This loop prints stars in each row iteratively
                System.out.print("*\t");
            }
            nst++; // incrementing total star for each row

            for (int j = 1; j <= nsp; j++) { // It handles spaces in each row iteratively
                System.out.print("\t");
            }
            nsp--; // incrementing total spaces in each row    

            System.out.println(); // to change line before changing row
        }
    }
}

    // The code above prints the pattern:

    // *	
    // *	*	
    // *	*	*	
    // *	*	*	*	
    // *	*	*	*	*	

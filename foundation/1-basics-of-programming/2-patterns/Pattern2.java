import java.util.*;

public class Pattern2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nst = n;
        int nsp = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= nst; j++) {
                System.out.print("*\t");
            }
            nst--;
            for (int k = 1; k <= nsp; k++) {
                System.out.print("\t");
            }
            nsp++;
            System.out.println();
        }
    }
}


// *	*	*	*	*	
// *	*	*	*		
// *	*	*			
// *	*				
// *	

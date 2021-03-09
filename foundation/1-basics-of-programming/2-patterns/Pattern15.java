import java.util.*;

public class Pattern15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {

        int nst = 1;
        int nsp = n / 2;
        int val = 1;

        for (int i = 1; i <= n; i++) {
            int xval = val;

            for (int j = 1; j <= nsp; j++) {
                System.out.print("\t");
            }

            for (int j = 1; j <= nst; j++) {
                System.out.print(xval + "\t");

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
                nsp++;
                nst -= 2;
                val--;
            }

            System.out.println();
        }
    }
}



// 	    	1	
// 	    2	3	2	
//  3	4	5	4	3	
//  	2	3	2	
// 		    1	













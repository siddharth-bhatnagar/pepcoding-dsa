import java.util.*;

public class Pattern12 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + "\t");
                int nextnum = a + b;
                a = b;
                b = nextnum;
            }
            System.out.println();
        }
    }
}



// 0	
// 1	1	
// 2	3	5	
// 8	13	21	34	
// 55	89	144	233	377	

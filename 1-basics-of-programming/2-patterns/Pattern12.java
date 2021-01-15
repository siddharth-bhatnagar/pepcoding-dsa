import java.util.*;

public class Pattern12 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int a = 0, b = 1, nextnum = 0;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(a + "	");
                nextnum = a + b;
                a = b;
                b = nextnum;
            }

            System.out.println();
        }

    }
}
import java.util.*;

public class AnyBaseSubtraction {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {
        int diff = 0;
        int p = 1;
        int c = 0;

        while (n1 > 0 || n2 > 0 || c > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            int d = c;
            d += d2;
            d -= d1;

            if (d < 0) {
                d = d + b;
                c = -1;
            } else {
                c = 0;
            }

            diff = diff + d * p;
            p = p * 10;

            n1 = n1 / 10;
            n2 = n2 / 10;
        }
        return diff;
    }

}
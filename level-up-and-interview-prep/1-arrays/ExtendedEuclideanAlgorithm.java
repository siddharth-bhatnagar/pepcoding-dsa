import java.util.*;

public class ExtendedEuclideanAlgorithm {

    public static class Pair {
        int x;
        int y;
        int gcd;

        public Pair(int x, int y, int gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        int gcd = gcd(a, b);
        Pair xyg = gcdExtended(a, b);

        System.out.println(gcd);
        System.out.println(xyg.x + " " + xyg.y + " " + xyg.gcd);

        scn.close();
    }

    // O(log min(a,b))
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int d = gcd(b, a % b);
        return d;
    }

    public static Pair gcdExtended(int a, int b) {
        if (b == 0) {
            return new Pair(1, 0, a);
        }

        Pair dash = gcdExtended(b, a % b);

        return new Pair(dash.y, dash.x - (a / b) * dash.y, dash.gcd);
    }
}
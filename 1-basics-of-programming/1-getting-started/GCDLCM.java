import java.util.*;

public class GCDLCM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int dividend = a;
        int divisor = b;

        while (dividend % divisor != 0) {
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        int gcd = divisor;
        int lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
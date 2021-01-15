import java.util.*;

public class PrimesTillN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            if (n == 1 || n == 0) {
                System.out.println("not prime");
                continue;
            }

            int count = 0;
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 1) {
                System.out.println("not prime");
            } else {
                System.out.println("prime");
            }
        }
    }
}
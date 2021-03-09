import java.io.*;
import java.util.*;

public class PowerLog {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        long x = scn.nextInt();
        long n = scn.nextInt();
        long ans = power(x, n);
        System.out.println(ans);
    }

    public static long power(long x, long n) {

        if (n == 0)
            return 1;
        long ans = power(x, n / 2) * power(x, n / 2);
        if (n % 2 != 0)
            ans = x * ans;

        return ans;
    }

}
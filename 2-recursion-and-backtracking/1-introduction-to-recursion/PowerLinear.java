import java.io.*;
import java.util.*;

public class PowerLinear {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int ans = power(x, n);
        System.out.println(ans);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int p1 = power(x, n - 1);
        int ans = p1 * x;
        return ans;
    }

}
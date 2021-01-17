import java.util.*;

public class AnyBaseToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int ans = anyBaseToAnyBase(n, sourceBase, destBase);
        System.out.println(ans);
    }

    public static int anyBaseToAnyBase(int n, int sb, int db) {
        int result;
        int inDecimal = anyBaseToDecimal(n, sb);
        int inDestBase = decimalToAnyBase(inDecimal, db);

        result = inDestBase;
        return result;
    }

    public static int anyBaseToDecimal(int n, int b) {
        int ans = 0;
        int pow = 1;
        while (n != 0) {
            int ld = n % 10;
            n = n / 10;
            ans += ld * pow;
            pow = pow * b;
        }
        return ans;
    }

    public static int decimalToAnyBase(int n, int b) {
        int ans = 0;
        int p = 1;
        while (n != 0) {
            int rem = n % b;
            n = n / b;
            ans += rem * p;
            p = p * 10;
        }
        return ans;
    }
}
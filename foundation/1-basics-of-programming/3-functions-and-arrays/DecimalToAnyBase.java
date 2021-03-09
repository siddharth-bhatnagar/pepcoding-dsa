import java.util.*;

public class DecimalToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        int ans = 0;
        int pow = 1;
        int divid = n;
        int div = b;
        while (divid != 0) {
            int rem = divid % div;
            ans = ans + rem * pow;
            pow = pow * 10;
            divid = divid / div;
        }
        return ans;
    }
}
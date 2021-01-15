import java.util.*;

public class InverseOfNumber {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int pos = 1;
        int inverse = 0;
        while (n > 0) {
            int invPos = n % 10;
            int invDigit = pos;

            inverse = inverse + invDigit * (int) Math.pow(10, invPos - 1);
            pos++;
            n = n / 10;
        }

        System.out.println(inverse);

    }
}
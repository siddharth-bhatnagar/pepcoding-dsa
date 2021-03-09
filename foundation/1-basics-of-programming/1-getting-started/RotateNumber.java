import java.util.*;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int nod = 0;
        int temp = n;
        while (temp != 0) {
            temp = temp / 10;
            nod++;
        }
        k = k % nod;
        if (k < 0) {
            k = k + nod;
        }

        int div = (int) Math.pow(10, k);
        int mult = (int) Math.pow(10, nod - k);
        int lastkDigits = n % div;
        n = n / div;
        int rotatedNumber = lastkDigits * mult + n;
        System.out.println(rotatedNumber);
    }
}
import java.util.*;

public class DigitsInNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int temp = n;
        int digit = 1;
        while (temp >= 10) {
            temp = temp / 10;
            digit = digit * 10;
        }

        while (digit != 0) {
            int fd = n / digit;
            System.out.println(fd);
            n = n % digit;
            digit = digit / 10;

        }
    }
}
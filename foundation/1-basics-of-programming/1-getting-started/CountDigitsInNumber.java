import java.util.*;

public class CountDigitsInNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nod = 0;
        while (n != 0) {
            nod++;
            n = n / 10;
        }

        System.out.println(nod);
    }
}
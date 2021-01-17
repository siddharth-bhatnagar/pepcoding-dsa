import java.io.*;
import java.util.*;

public class RemovePrimes {

    public static void solution(ArrayList<Integer> al) {

        for (int i = al.size() - 1; i >= 0; i--) {
            int n = al.get(i);
            if (n == 1 || n == 0) {
                al.remove(i);
                continue;
            }

            int flag = 0;
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                al.remove(i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }
}
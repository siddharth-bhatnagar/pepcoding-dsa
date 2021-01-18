import java.io.*;
import java.util.*;

public class PrintIncreasing {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printDecreasing(n);
    }

    public static void printDecreasing(int n) {
        if (n == 0)
            return;
        printDecreasing(n - 1);
        System.out.println(n);
    }
}
import java.io.*;
import java.util.*;

public class Zigzag {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n) {
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
    }

}


//  3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
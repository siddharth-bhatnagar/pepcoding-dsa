import java.io.*;
import java.util.*;

public class StringCompression {

    public static String compression1(String str) {

        int len = str.length();
        String val = "";
        val = val + str.charAt(0);
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                val += str.charAt(i);
            }
        }
        return val;
    }

    public static String compression2(String str) {

        int len = str.length();
        String val = "";
        val = val + str.charAt(0);
        int count = 1;

        for (int i = 1; i < len; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (count > 1) {
                    val += count;
                }
                val += str.charAt(i);
                count = 0;
            }
            count++;
        }
        if (count > 1) {
            val += count;
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }

}
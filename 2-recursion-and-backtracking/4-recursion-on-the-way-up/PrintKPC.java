import java.io.*;
import java.util.*;

public class PrintKPC {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String st = scn.nextLine();
        printKPC(st, "");
    }

    static String[] keypad = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void printKPC(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char fChar = str.charAt(0);
        String rs = str.substring(1);
        String value = keypad[fChar - '0'];

        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            printKPC(rs, ans + ch);
        }
    }
}
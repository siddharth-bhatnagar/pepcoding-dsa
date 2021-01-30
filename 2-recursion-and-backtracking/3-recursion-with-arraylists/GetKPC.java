import java.io.*;
import java.util.*;

public class GetKPC {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String st = scn.nextLine();
        ArrayList < String > ans = getKPC(st);
        System.out.println(ans);
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

    public static ArrayList < String > getKPC(String str) {

        if (str.length() == 0) {
            ArrayList < String > temp = new ArrayList < > ();
            temp.add("");
            return temp;
        }

        char fChar = str.charAt(0);
        String rs = str.substring(1);
        String value = keypad[fChar - '0'];
        ArrayList < String > preResult = getKPC(rs);
        ArrayList < String > result = new ArrayList < > ();

        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            for (int j = 0; j < preResult.size(); j++) {
                result.add(ch + preResult.get(j));
            }
        }
        return result;
    }
}
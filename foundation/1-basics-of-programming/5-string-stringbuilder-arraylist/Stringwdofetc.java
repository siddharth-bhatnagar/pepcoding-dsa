import java.io.*;
import java.util.*;

public class Stringwdofetc {

    public static String solution(String str) {
        int len = str.length();
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        for (int i = 1; i < len; i++) {
            int c1 = str.charAt(i - 1);
            int c2 = str.charAt(i);
            int d = c2 - c1;
            ans.append(d);
            ans.append(str.charAt(i));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
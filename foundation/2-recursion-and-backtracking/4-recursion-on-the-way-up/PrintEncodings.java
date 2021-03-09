import java.util.*;
import java.io.*;

public class PrintEncodings {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());

        printEncodings(str, "");
    }

    public static void printEncodings(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        } else if (ques.length() == 1) {
            char ch = ques.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                asf = asf + code;
                System.out.println(asf);
                return;
            }
        } else {
            char fc = ques.charAt(0);
            if (fc == '0') {
                return;
            } else {
                String ros1 = ques.substring(1);
                int chv = fc - '0';
                char code = (char) ('a' + chv - 1);
                printEncodings(ros1, asf + code);
                String sub = ques.substring(0, 2);
                int val = Integer.parseInt(sub);
                val = val - 1;
                if (val >= 0 && val <= 26) {
                    char cd = (char) ('a' + val);
                    String ros2 = ques.substring(2);
                    printEncodings(ros2, asf + cd);
                }
            }

        }
    }
}
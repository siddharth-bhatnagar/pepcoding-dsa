import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        String smnfp = smallestNumberFollowingPattern(str);
        System.out.println(smnfp);
    }

    public static String smallestNumberFollowingPattern(String str) {
        StringBuilder ans = new StringBuilder();
        Stack < Integer > stack = new Stack < > ();
        int val = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'd') {
                stack.push(val);
                val++;
            } else {
                stack.push(val);
                val++;
                while (stack.size() > 0) {
                    ans.append(stack.pop());
                }
            }
        }
        stack.push(val);
        while (stack.size() > 0) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}
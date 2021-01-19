import java.io.*;
import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());
        Stack < Character > stack = new Stack < > ();
        for (int i = 0; i <= str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.size() == 0) {
                    System.out.println("false");
                    return;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        System.out.println("false");
                        return;
                    }
                }
            } else if (ch == '}') {
                if (stack.size() == 0) {
                    System.out.println("false");
                    return;
                } else {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        System.out.println("false");
                        return;
                    }
                }
            } else if (ch == ']') {
                if (stack.size() == 0) {
                    System.out.println("false");
                    return;
                } else {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        System.out.println("false");
                        return;
                    }
                }
            } else {
                continue;
            }
        }
        if (stack.size() != 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
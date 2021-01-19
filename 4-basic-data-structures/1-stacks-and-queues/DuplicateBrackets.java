import java.io.*;
import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (stack.peek() == '(') {
                    System.out.println("true");
                    stack.pop();
                    return;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        System.out.println("false");
    }
}
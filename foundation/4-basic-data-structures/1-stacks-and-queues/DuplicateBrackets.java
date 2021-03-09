import java.io.*;
import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());
        duplicateBrackets(str);
    }

    public static void duplicateBrackets(String str) {
        Stack < Character > stack = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (stack.peek() == '(') {
                    System.out.println(true);
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
        System.out.println(false);
    }
}

/*
Assumption - the given expression is balanced.
Approach

if stack is empty, push element in stack till first closing bracket is encountered.
peek at the top of stack, if top = opening bracket, then there are duplicates else 
keep popping till first opening bracket is found, then pop that as well.

**/
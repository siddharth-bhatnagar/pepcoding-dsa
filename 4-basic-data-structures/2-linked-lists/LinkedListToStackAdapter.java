import java.io.*;
import java.util.*;

public class LinkedListToStackAdapter {

    public static class LLToStackAdapter {
        LinkedList < Integer > list;

        public LLToStackAdapter() {
            list = new LinkedList < > ();
        }


        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            int val = list.removeFirst();
            return val;
        }

        int top() {
            if (list.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            int val = list.getFirst();
            return val;
        }
    }

    // To implement a stack using inbuilt linked list class, there are two ways:
    // Using addFirst() and removeFirst() methods
    // Using addLast() and removeLast() methods
    // The second one is not recommended because in some languages removeLast might have O(n) time complexity 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}
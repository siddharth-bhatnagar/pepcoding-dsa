import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    // Pre-order --> push child nodes in reverse order
    // Post-order --> Use two stacks, push child nodes in serial order in helper stack, pop from helper and push to post order stack
    // O(n) time + O(n) space
    // There is no inorder in generic tree since each node is visited a number of times between pre and post
    public static void IterativePreandPostOrder1(Node node) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> helper = new Stack<>();
        Stack<Node> post = new Stack<>();

        stack.push(node);
        helper.push(node);

        while (stack.size() > 0) {
            // preorder
            node = stack.pop();
            System.out.print(node.data + " ");
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }

            // postorder
            node = helper.pop();
            post.push(node);
            for (Node child : node.children) {
                helper.push(child);
            }
        }
        System.out.println();

        // printing post order
        while (post.size() > 0) {
            System.out.print(post.pop().data + " ");
        }
    }

    public class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    // Using Pair class and single stack
    // state: -1 --> append in pre order
    // state: 0 to node.children.size() - 1 --> push child at that index into stack
    // state: node.children.size() --> append node in post order  
    // O(n) time, O(H) space if you don't count output strings
    public static void IterativePreandPostOrder2(Node root) {
        Stack<Pair> stack = new Stack<>();
        StringBuilder preorder = new StringBuilder();
        StringBuilder postorder = new StringBuilder();

        Pair rp = new Pair(root, -1);
        stack.push(rp);

        while(stack.size() > 0) {
            Pair p = stack.peek();
            if(p.state == -1) {
                preorder.append(p.node.data + " ");
                p.state++;
            }
            else if(p.state < p.node.children.size()) {
                p.state++;
                stack.push(new Pair(p.node.children.get(p.state-1), -1));                
            }
            // state == p.node.children.size()
            else {
                postorder.append(p.node.data + " ");
                stack.pop();
            }
        }

        System.out.println(preorder);
        System.out.println(postorder);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // IterativePreandPostOrder1(root);
        IterativePreandPostOrder2(root);
    }

}
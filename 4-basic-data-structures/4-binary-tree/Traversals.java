import java.io.*;
import java.util.*;

public class Traversals {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void iterativePrePostInTraversal(Node node) {
        // write your code here
        Stack <Pair> stack = new Stack<>();
        Pair rp = new Pair(node, 1);
        stack.push(rp);

        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        while(stack.size()>0){
            Pair tp = stack.peek();
        
            if(tp.state==1){ // pre, s++, left
                pre.append(tp.node.data + " ");  
                tp.state++;
                if(tp.node.left!=null){
                    Pair np = new Pair(tp.node.left, 1);
                    stack.push(np);
                }      
            }
            else if(tp.state==2){ // in, s++, right
                in.append(tp.node.data + " ");  
                tp.state++;
                if(tp.node.right!=null){
                    Pair np = new Pair(tp.node.right, 1);
                    stack.push(np);
                }
            }
            else{           // post, pop()
                post.append(tp.node.data + " ");
                stack.pop();  
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    public static void recursivePrePostInTraversal(Node node) {
        
        System.out.println(node.data + "In Pre-order");
        recursivePrePostInTraversal(node.left);
        System.out.println(node.data + "In In-order");
        recursivePrePostInTraversal(node.right);
        System.out.println(node.data + "In Post-order");

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        iterativePrePostInTraversal(root);
    }

}
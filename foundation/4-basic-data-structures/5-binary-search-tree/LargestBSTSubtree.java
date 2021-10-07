import java.io.*;
import java.util.*;

public class LargestBSTSubtree {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
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

    private static Node construct(Integer[] arr) {
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

    private static class Meta {
        boolean isBST;
        long min;
        long max;
        Node rootLargestBST;
        int sizeLargestBST;

        public Meta(boolean isBST, long min, long max, Node rootLargestBST, int sizeLargestBST) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.rootLargestBST = rootLargestBST;
            this.sizeLargestBST = sizeLargestBST;
        }

        public Meta() {

        }
    }

    public static void main(String... args) throws Exception {
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
        Meta info = solve(root);
        System.out.println(info.rootLargestBST.data + "@" + info.sizeLargestBST);
    }

    private static Meta solve(Node node) {
        if (node == null) {
            Meta info = new Meta(true, Long.MAX_VALUE, Long.MIN_VALUE, null, 0);
            return info;
        }

        Meta left = solve(node.left);
        Meta right = solve(node.right);

        Meta info = new Meta();
        info.isBST = left.isBST && right.isBST && (node.data > left.max && node.data < right.min);
        info.min = Math.min(node.data, Math.min(left.min, right.min));
        info.max = Math.max(node.data, Math.max(right.max, left.max));

        if (info.isBST) {
            info.rootLargestBST = node;
            info.sizeLargestBST = left.sizeLargestBST + right.sizeLargestBST + 1;
        }
        else if (left.sizeLargestBST > right.sizeLargestBST) {
            info.rootLargestBST = node.left;
            info.sizeLargestBST = left.sizeLargestBST;
        } else {
            info.rootLargestBST = node.right;
            info.sizeLargestBST = right.sizeLargestBST;
        }

        return info;
    }
}
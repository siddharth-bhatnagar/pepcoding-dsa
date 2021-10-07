import java.io.*;
import java.util.*;

public class IsBST {
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    private static class DPair {
        boolean bst;
        int min;
        int max;
    }
    
    public static DPair isBST(Node node) {
        if(node == null) {
            DPair temp = new DPair();
            temp.bst = true;
            temp.min = Integer.MAX_VALUE;
            temp.max = Integer.MIN_VALUE;
            return temp;
        }

        DPair lt = isBST(node.left);
        DPair rt = isBST(node.right);

        DPair fp = new DPair();
        fp.bst = lt.bst && rt.bst && (node.data>lt.max && node.data<rt.min);
        fp.min = Math.min(lt.min, Math.min(rt.min, node.data));
        fp.max = Math.max(lt.max, Math.max(rt.max, node.data));

        return fp;
    }

    public static boolean isBST2(Node root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(Node node, long min, long max) {
        if(node == null) return true;
        if(node.data >= max || node.data <= min) return false;

        boolean left = helper(node.left, min, node.data);
        boolean right = helper(node.left, node.data, max);

        return (left && right);
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
        DPair ans = isBST(root);
        System.out.println(ans.bst);
    }

}
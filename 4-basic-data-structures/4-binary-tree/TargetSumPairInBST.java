import java.io.*;
import java.util.*;

public class TargetSumPairInBST {
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

    // O(n*h)
    public static void pairSum(Node node, int target, Node actualRoot) {
        if (node == null) {
            return;
        }
        pairSum(node.left, target, actualRoot);
        int x = node.data;
        int xdash = target - node.data;
        if (xdash > x) {
            boolean flag = find(actualRoot, xdash);
            if (flag)
                System.out.println(x + " " + xdash);
        }
        pairSum(node.right, target, actualRoot);
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data > data) {
            return find(node.left, data);
        } else if (node.data < data) {
            return find(node.right, data);
        } else {
            return true;
        }
    }

    static ArrayList<Integer> inorder;

    public static void pairSumO2n(Node node) {
        if (node == null) {
            return;
        }

        pairSumO2n(node.left);
        inorder.add(node.data);
        pairSumO2n(node.right);
    }

    // O(2n)
    public static void ptsp(Node node, int target) {
        inorder = new ArrayList<>();
        pairSumO2n(node);
        int si = 0;
        int ei = inorder.size() - 1;
        while (si != ei) {
            int sum = inorder.get(si) + inorder.get(ei);
            if (sum < target) {
                si++;
            } else if (sum > target) {
                ei--;
            } else {
                System.out.println(inorder.get(si) + " " + inorder.get(ei));
                si++;
                ei--;
            }
        }
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        // write your code here
        pairSum(root, data, root);
        ptsp(root, data);
    }

}
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

    // O(N*H) or O(NlogN)
    public static void approach1(Node node, int target, Node root) {
        if (node == null)
            return;

        approach1(node.left, target, root);
        int comp = target - node.data;
        if (node.data < comp && find(root, comp)) {
            System.out.println(node.data + " " + comp);
        }
        approach1(node.right, target, root);
    }

    public static boolean find(Node node, int data) {
        if (node == null)
            return false;

        if (node.data > data) {
            return find(node.left, data);
        } else if (node.data < data) {
            return find(node.right, data);
        } else {
            return true;
        }
    }

    // O(2*N), O(N)
    static ArrayList<Integer> inorder;

    public static void approach2(Node node, int target) {
        inorder = new ArrayList<Integer>();
        inorderTraversal(node);
        int i = 0;
        int j = inorder.size() - 1;

        while (i < j) {
            int a = inorder.get(i);
            int b = inorder.get(j);
            if ((a + b) < target) {
                i++;
            } else if ((a + b) > target) {
                j--;
            } else {
                System.out.println(a + " " + b);
                i++;
                j--;
            }
        }
    }

    public static void inorderTraversal(Node node) {
        if (node == null)
            return;
        inorderTraversal(node.left);
        inorder.add(node.data);
        inorderTraversal(node.right);
    }

    // O(N), O(H)
    public static void approach3(Node root, int target) {
        Stack<Pair> lc = new Stack<>();
        Stack<Pair> rc = new Stack<>();
        lc.push(new Pair(root, 0));
        rc.push(new Pair(root, 0));

        // Inorder, Reverse Inorder
        Node start = getChildInorder(lc);
        Node end = getChildRevInorder(rc);

        while (start != end) {
            if (start.data + end.data < target) {
                start = getChildInorder(lc);
            } else if (start.data + end.data > target) {
                end = getChildRevInorder(rc);
            } else {
                System.out.println(start.data + " " + end.data);
                start = getChildInorder(lc);
                end = getChildRevInorder(rc);
            }
        }

    }

    public static Node getChildInorder(Stack<Pair> stack) {
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 0) {
                if (top.node.left != null)
                    stack.push(new Pair(top.node.left, 0));
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null)
                    stack.push(new Pair(top.node.right, 0));
                top.state++;
                return top.node;
            } else {
                stack.pop();
            }
        }

        return null;
    }

    public static Node getChildRevInorder(Stack<Pair> stack) {
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 0) {
                if (top.node.right != null)
                    stack.push(new Pair(top.node.right, 0));
                top.state++;
            } else if (top.state == 1) {
                if (top.node.left != null)
                    stack.push(new Pair(top.node.left, 0));
                top.state++;
                return top.node;
            } else {
                stack.pop();
            }
        }

        return null;
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
        approach1(root, data, root);
        approach2(root, data);
        approach3(root, data);
    }

}
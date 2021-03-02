import java.io.*;
import java.util.*;

public class BinaryTreeConstructionAndDisplay {

    // Creating node class
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

    // Creating Pair class
    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // To construct binary tree
    public static Node construct(Integer[] arr) {

        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);

        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);

        for (int i = 1; i < arr.length; i++) {

            Pair topPair = stack.peek();

            if (topPair.state == 1) {

                if (arr[i] != null) {
                    Node left = new Node(arr[i], null, null);
                    topPair.node.left = left;
                    Pair toBePushed = new Pair(left, 1);
                    stack.push(toBePushed);
                }

                topPair.state++;
            } else if (topPair.state == 2) {

                if (arr[i] != null) {
                    Node right = new Node(arr[i], null, null);
                    topPair.node.right = right;

                    Pair toBePushed = new Pair(right, 1);
                    stack.push(toBePushed);
                }

                topPair.state++;
            } else {
                stack.pop();
                i--;
            }

        }
        return root;
    }

    // To display the constructed binary tree
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        StringBuilder ans = new StringBuilder(new String(node.data + " -> "));

        if (node.left != null) {
            ans.append(node.left.data + ", ");
        } else {
            ans.append("., ");
        }

        if (node.right != null) {
            ans.append(node.right.data + ", ");
        } else {
            ans.append("., ");
        }

        ans.append(".");
        System.out.println(ans);

        display(node.left);
        display(node.right);
    }

    // Driver Program
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int n = Integer.parseInt(br.readLine());
        // Integer[] arr = new Integer[n];

        // for(int i=0;i<arr.length;i++){
        // arr[i] = Integer.parseInt(br.readLine());
        // }

        Integer[] arr = { 10, 20, 40, 80, null, null, 90, null, null, 50, 100, null, null, null, 30, 60, null, null, 70,
                110, 130, null, null, 140, null, null, 120, null, null };

        Node root = construct(arr);
        display(root);
    }

}
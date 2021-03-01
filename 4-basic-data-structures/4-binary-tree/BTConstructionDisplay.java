import java.util.*;
import java.io.*;

public class Main {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    private static class Pair {
        TreeNode n;
        int state;
    }

    public static TreeNode constructBinaryTree(int[] arr) {

        TreeNode root = new TreeNode();
        Stack<Pair> stack = new Stack<>();

        root.data = arr[0];

        Pair rootPair = new Pair();
        rootPair.n = root;
        rootPair.state = 1;

        stack.push(rootPair);

        for (int i = 1; i < arr.length; i++) {
            Pair topPair = stack.peek();

            if (topPair.state == 1) {
                if (arr[i] == -1) {
                    topPair.n.left = null;
                } else {
                    TreeNode onLeft = new TreeNode();
                    onLeft.data = arr[i];
                    topPair.n.left = onLeft;

                    Pair temp = new Pair();
                    temp.n = onLeft;
                    temp.state = 1;
                    stack.push(temp);
                }
                topPair.state++;
            } else if (topPair.state == 2) {
                if (arr[i] == -1) {
                    topPair.n.right = null;
                } else {
                    TreeNode onRight = new TreeNode();
                    onRight.data = arr[i];
                    topPair.n.right = onRight;

                    Pair temp = new Pair();
                    temp.n = onRight;
                    temp.state = 1;
                    stack.push(temp);
                }
                topPair.state++;
            }
            // state = 3
            else {
                stack.pop();
                i--;
            }
        }

        return root;
    }

    public static void display(TreeNode node) {

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

    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int[] arr = new int[Integer.parseInt(br.readLine())];
        // for(int i=0;i<arr.length;i++){
        // arr[i] = Integer.parseInt(br.readLine());
        // }

        int[] arr = { 10, 12, 16, -1, -1, 18, -1, -1, 14, 20, -1, -1, 22, -1, -1 }; // for testing

        TreeNode root = constructBinaryTree(arr);
        display(root);
    }
}
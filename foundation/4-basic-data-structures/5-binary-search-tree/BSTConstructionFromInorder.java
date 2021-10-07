import java.io.*;
import java.util.*;

public class BSTConstructionFromInorder {
    public static void main(String... args) throws Exception {
        int[] arr = { 12, 25, 30, 37, 40, 50, 60, 62, 65, 75, 87 };
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }

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

    public static Node construct(int[] arr, int lo, int hi) {
        if(lo > hi) return null;

        int mid = (lo + hi) / 2;
        int data = arr[mid];

        Node lc = construct(arr, lo, mid-1);
        Node rc = construct(arr, mid+1, hi);

        return new Node(data, lc, rc);
    }
}

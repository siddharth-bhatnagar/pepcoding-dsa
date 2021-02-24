import java.util.*;
import java.io.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static class GenericTree {
        Node root;

        Node constructGenericTree(int[] arr) {
            Stack<Node> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1) {
                    stack.pop();
                } else {
                    Node n = new Node();
                    n.data = arr[i];

                    if (stack.size() == 0) {
                        this.root = n;
                    } else {
                        stack.peek().children.add(n);
                    }
                    stack.push(n);
                }
            }
            return root;
        }

        public void display(Node node) {
            StringBuilder branch = new StringBuilder(node.data + " -> ");
            for (int i = 0; i < node.children.size(); i++) {
                Node child = node.children.get(i);
                branch.append(child.data + ", ");
            }
            System.out.println(branch);
            for (int i = 0; i < node.children.size(); i++) {
                Node child = node.children.get(i);
                display(child);
            }
        }
    }

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int arr[] = new int[scn.nextInt()];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = scn.nextInt();
        // }
        int[] arr = { 10, 12, -1, 14, 18, -1, 20, 22, -1, 24, -1, 26, -1, -1, -1, 16, 28, -1, -1, -1 };
        GenericTree tree = new GenericTree();
        Node root = tree.constructGenericTree(arr);
        tree.display(root);
    }
}
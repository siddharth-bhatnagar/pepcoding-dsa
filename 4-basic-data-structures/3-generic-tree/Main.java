// Introduction to hierarchical Data Structures
// Examples - folders in a directory

// Generic Tree 
// It has a root node which has variable number of children and child nodes which does not have any children is called leaf node.
// Terminology
// Ancestor - all nodes before the current node in euler path.
// Descendant - the subtree beneath the current node.
// Parent - The node immediately before the current node.
// child - The node immediately after the current node.
// Root - Node which has no parent.

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructGenericTree(int[] arr) {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == -1) {
                stack.pop();
            } else {

                Node temp = new Node();
                temp.data = arr[i];

                if (stack.isEmpty()) {
                    root = temp;
                } else {
                    stack.peek().children.add(temp);
                }
                stack.push(temp);
            }
        }
        return root;
    }

    public static void displayGenericTree(Node node){
        StringBuilder sb = new StringBuilder(new String(node.data + " -> "));
        for(Node child: node.children){
            sb.append(child.data + ", ");
        }
        sb.append(".");
        System.out.println(sb);
        for(Node child: node.children){
            displayGenericTree(child);
        }
    }

    public static void main(String[] args) { // Driver Program

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int[] treeNodesInfo = new int[n];
        // for (int i = 0; i < treeNodesInfo.length; i++) {
        // treeNodesInfo[i] = Integer.parseInt(br.readLine());
        // }
        int[] treeNodesInfo = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
                -1, -1, -1 };
        Node root = constructGenericTree(treeNodesInfo);
        displayGenericTree(root);
    }
}

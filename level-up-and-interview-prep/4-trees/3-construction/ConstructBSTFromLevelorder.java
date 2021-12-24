// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends

// User function Template for Java

class GFG {
    // Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(null, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int idx = 0;
        Node root = null;

        while (queue.size() > 0 && idx < arr.length) {
            Pair rem = queue.removeFirst();
            int val = arr[idx];
            if (val >= rem.min && val <= rem.max) {
                Node node = new Node(val);

                if (root == null)
                    root = node;
                else if (rem.parent.data > node.data)
                    rem.parent.left = node;
                else if (rem.parent.data < node.data)
                    rem.parent.right = node;

                queue.addLast(new Pair(node, rem.min, node.data - 1));
                queue.addLast(new Pair(node, node.data + 1, rem.max));

                idx++;
            }
        }

        return root;
    }

    private class Pair {
        Node parent;
        int min;
        int max;

        public Pair(Node parent, int min, int max) {
            this.parent = parent;
            this.min = min;
            this.max = max;
        }
    }
}
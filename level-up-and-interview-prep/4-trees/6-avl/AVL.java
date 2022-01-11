import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class AVL {
    public static void main(String[] args) {
        Node root = new Node(1);
        root = insertion(root, 2);
        root = insertion(root, 3);
        root = insertion(root, 4);
        root = insertion(root, 5);
        root = insertion(root, 6);
        root = insertion(root, 7);
        root = insertion(root, 8);
        root = insertion(root, 9);
        root = insertion(root, 10);
        root = insertion(root, 11);
        root = insertion(root, 12);
        root = insertion(root, 13);
        root = insertion(root, 14);

        display(root);
        System.out.println("==========================================");
        root = deletion(root, 7);
        display(root);
    }

    private static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.height = 1;
        }
    }

    private static void display(Node root) {
        if(root == null) return;

        StringBuilder sb = new StringBuilder();

        if(root.left != null) sb.append(root.left.data + " <- ");
        else sb.append(". <- ");
        sb.append(root.data);
        if(root.right != null) sb.append(root.right.data + " -> ");
        else sb.append(" -> . ");

        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    private static Node insertion(Node root, int data) {
        if(root == null) return new Node(data);
        else if(root.data < data) {
            root.right = insertion(root.right, data);
        }
        else if(root.data > data) {
            root.left = insertion(root.left, data);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int gap = getBalance(root);

        if(gap > 1 && root.left.data > data) {
            root = rightRotate(root);
        }
        else if(gap > 1 && root.left.data < data) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        else if(gap < -1 && root.right.data < data) {
            root = leftRotate(root); 
        }
        else if(gap < -1 && root.right.data > data) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }

        return root;
    }

    private static Node deletion(Node root, int key) {
        if(root == null) return root;
        else if(root.data < key) {
            root.right = deletion(root.right, key);
        }
        else if(root.data > key) {
            root.left = deletion(root.left, key);
        }
        else {
            if(root.left == null || root.right == null) {
                return root.left != null ? root.left:root.right;
            }

            Node mx = getMaxNode(root.left);
            root.data = mx.data;

            root.left = deletion(root.left, mx.data);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int gap = getBalance(root);

        if(gap > 1 && getBalance(root.left) >= 0) {
            root = rightRotate(root);
        }
        else if(gap > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        else if(gap < -1 && getBalance(root.right) <= 0) {
            root = leftRotate(root); 
        }
        else if(gap < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }

        return root;
    }

    private static Node leftRotate(Node A) {
        Node B = A.right;
        Node root = B;

        Node T2 = B.left;
        B.left = A;
        A.right = T2;
        
        A.height = Math.max(height(A.left), height(A.right)) + 1;
        B.height = Math.max(height(B.left), height(B.right)) + 1;

        return root;
    } 

    private static Node rightRotate(Node A) {
        Node B = A.left;
        Node root = B;
        
        Node T2 = B.right;
        B.right = A;
        A.left = T2;
        
        A.height = Math.max(height(A.left), height(A.right)) + 1;
        B.height = Math.max(height(B.left), height(B.right)) + 1;
        
        return root;
    }

    private static int height(Node node) {
        if(node == null) return 0;
        return node.height;
    }

    private static int getBalance(Node node) {
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static Node getMaxNode(Node node) {
        while(node.right != null) node = node.right;
        return node;
    }
}
class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = null;
    }
}

class Solution {
    public Node insertToAVL(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (node.data < data) {
            node.right = insertToAVL(node.right, data);
        } else if (node.data > data) {
            node.left = insertToAVL(node.left, data);
        }

        int leftH = height(node.left);
        int rightH = height(node.right);

        node.height = Math.max(leftH, rightH) + 1;

        int gap = leftH - rightH;
        Node newRoot = node;
        if (gap > 1 && data < node.left.data) { // LL
            newRoot = rightRotate(node);
        } else if (gap > 1 && data > node.left.data) { // LR
            node.left = leftRotate(node.left);
            newRoot = rightRotate(node);
        } else if (gap < -1 && data > node.right.data) { // RR
            newRoot = leftRotate(node);
        } else if (gap < -1 && data < node.right.data) { // RL
            node.right = rightRotate(node.right);
            newRoot = leftRotate(node);
        }

        return newRoot;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private Node rightRotate(Node a) {
        Node b = a.left;

        Node root = b;
        Node t2 = b.right;

        b.right = a;
        a.left = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return root;
    }

    private Node leftRotate(Node a) {

        Node b = a.right;

        Node root = b;
        Node t2 = b.left;

        b.left = a;
        a.right = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return root;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
// Leetcode 426
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node tail = bstToDll(root);
        return tail.right;
    }

    private Node bstToDll(Node node) {
        if (node == null)
            return null;

        Node lt = bstToDll(node.left);
        Node rt = bstToDll(node.right);

        node.left = node;
        node.right = node;

        if (lt == null && rt == null) {
            return node;
        } else if (lt == null) {
            Node tail = add(node, rt);
            return tail;
        } else if (rt == null) {
            Node tail = add(lt, node);
            return tail;
        } else {
            Node tail = add(lt, node);
            Node tail2 = add(tail, rt);
            return tail2;
        }
    }

    private Node add(Node t1, Node t2) {
        Node h1 = t1.right;
        Node h2 = t2.right;
        t1.right = h2;
        h2.left = t1;
        h1.left = t2;
        t2.right = h1;
        return t2;
    }
}
class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = null;
    }
}


class Sol {
    public static Node deleteNode(Node root, int key) {
        if (root == null)
            return null;

        if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }

            Node max = getMaxVal(root.left);
            root.data = max.data;

            root.left = deleteNode(root.left, max.data);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int gap = getBalance(root);

        if (gap > 1 && getBalance(root.left) >= 0) { // LL
            root = rightRotate(root);
        } else if (gap > 1 && getBalance(root.left) < 0) { // LR
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        } else if (gap < -1 && getBalance(root.right) > 0) { // RL
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        } else if (gap < -1 && getBalance(root.right) <= 0) { // RR
            root = leftRotate(root);
        }

        return root;
    }

    private static Node getMaxVal(Node node) {
        Node curr = node;
        while (curr.right != null) {
            curr = curr.right;
        }

        return curr;
    }

    private static int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private static Node leftRotate(Node a) {
        Node b = a.right;
        Node t2 = b.left;

        b.left = a;
        a.right = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return b;
    }

    private static Node rightRotate(Node a) {
        Node b = a.left;
        Node t2 = b.right;

        b.right = a;
        a.left = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return b;
    }

}
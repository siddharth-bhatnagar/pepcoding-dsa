import java.util.*;

public class BSTToGreaterSumTree {

    // TreeNode class for a node of a Binary Search Tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // This is a functional problem. You have to complete this function.
    // It takes as input the root of the given BST. It should return the root
    // of the resultant tree.
    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        bstToGst(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst(root.left);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // length of array representing the tree
        int len = sc.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = levelOrder(arr);

        TreeNode resultRoot = bstToGst(root);

        display(resultRoot);

    }

    // utility function to display a binary tree
    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.val;
        str += " <= " + node.val + " => ";
        str += node.right == null ? "." : node.right.val;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // creation of tree from array by level order, -1 says there is no node
    public static TreeNode levelOrder(int[] arr) {

        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);

                if (i > 0) {
                    int pi = (i - 1) / 2;

                    if (i == 2 * pi + 1) {
                        nodes[pi].left = nodes[i];
                    } else {
                        nodes[pi].right = nodes[i];
                    }
                }
            }
        }

        TreeNode root = nodes[0];
        return root;
    }

}
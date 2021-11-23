// Leetcode 222

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int leftH = getHeightLeft(root);
        int rightH = getHeightRight(root);

        if (leftH == rightH)
            return ((1 << leftH) - 1);

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }

    public static int getHeightLeft(TreeNode node) {
        int c = 1;
        while (node.left != null) {
            node = node.left;
            c++;
        }

        return c;
    }

    public static int getHeightRight(TreeNode node) {
        int c = 1;
        while (node.right != null) {
            node = node.right;
            c++;
        }

        return c;
    }
}
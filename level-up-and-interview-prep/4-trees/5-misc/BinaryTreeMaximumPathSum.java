// Leetcode 124

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    static int omax;

    public int maxPathSum(TreeNode root) {
        omax = Integer.MIN_VALUE;
        solve(root);
        return omax;
    }

    public static int solve(TreeNode node) {
        if (node == null)
            return 0;

        int left = solve(node.left);
        int right = solve(node.right);
        int val = node.val;
        omax = Math.max(val, omax);
        omax = Math.max(omax, val + left);
        omax = Math.max(omax, val + right);
        omax = Math.max(omax, val + left + right);

        return Math.max(val, Math.max(val + left, val + right));
    }
}
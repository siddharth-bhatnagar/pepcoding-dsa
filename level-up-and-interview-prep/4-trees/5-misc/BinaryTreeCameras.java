/**
 * Leetcode 968 Definition for a binary tree node. public class TreeNode { int
 * val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) {
 * this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val
 * = val; this.left = left; this.right = right; } }
 */
class Solution {
    static int count;

    public int minCameraCover(TreeNode root) {
        count = 0;
        int val = solve(root);
        // If parent behaves as leaf node
        if (val == 0)
            count++;
        return count;
    }

    // 0 - leaf/dummy leaf node, 1 - leaf's parent with cam
    // 2 - non-leaf node without camera but being observed
    // 00 || 01 || 02 || return 1, increase count
    // 11 || 12 return 2 , 22 - return 0

    public static int solve(TreeNode node) {
        if (node == null)
            return 2;

        int left = solve(node.left);
        int right = solve(node.right);

        if (((right == 0 || right == 1 || right == 2) && left == 0)
                || ((left == 0 || left == 1 || left == 2) && right == 0)) {
            count++;
            return 1;
        } else if ((left == 1 && right == 1) || (left == 1 && right == 2) || (right == 1 && left == 2))
            return 2;

        return 0;

    }
}
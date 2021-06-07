// Leetcode 99

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        ans1 = null;
        ans2 = null;

        traversal(root);

        int temp = ans1.val;
        ans1.val = ans2.val;
        ans2.val = temp;
    }

    static TreeNode prev;
    static TreeNode ans1;
    static TreeNode ans2;

    public static void traversal(TreeNode curr) {
        if (curr == null)
            return;

        traversal(curr.left);

        if (ans1 == null && curr.val < prev.val) {
            ans1 = prev;
            ans2 = curr;
        } else if (curr.val < prev.val) {
            ans2 = curr;
        }

        prev = curr;

        traversal(curr.right);
    }
}

// N-Number of nodes
// Time: O(N)
// Space: O(H) 

// Can be optimised to O(1) extra space using morris inorder traversal
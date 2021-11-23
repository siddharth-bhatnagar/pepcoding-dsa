// Leetcode 1008

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int idx;

    public TreeNode construct(int[] pre, int min, int max) {
        if (idx == pre.length)
            return null;

        if (pre[idx] <= max && pre[idx] >= min) {
            TreeNode root = new TreeNode(pre[idx]);
            int key = pre[idx];
            idx++;

            root.left = construct(pre, min, key - 1);
            root.right = construct(pre, key + 1, max);

            return root;
        }

        return null;
    }
}

// Complexity O(N), O(H)
// Leetcode 337 - House Robber in a binary tree
// O(N) time, O(H) space

class Solution {
    public int rob(TreeNode root) {
        Pair rootPair = robb(root);
        return Math.max(rootPair.with, rootPair.without);
    }

    private Pair robb(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);

        Pair leftPair = robb(root.left);
        Pair rightPair = robb(root.right);

        int w = leftPair.without + rightPair.without + root.val;
        int wo = Math.max(leftPair.with, leftPair.without) + Math.max(rightPair.with, rightPair.without);

        return new Pair(w, wo);
    }

    private class Pair {
        int with;
        int without;

        public Pair(int with, int without) {
            this.with = with;
            this.without = without;
        }
    }
}
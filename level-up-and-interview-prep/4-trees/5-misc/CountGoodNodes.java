class Solution {
    public int goodNodes(TreeNode root) {
        return solve(root, Integer.MIN_VALUE);
    }

    private int solve(TreeNode node, int max) {
        if (node == null)
            return 0;

        max = Math.max(max, node.val);

        int good = 0;
        if (max <= node.val)
            good++;

        int left = solve(node.left, max);
        int right = solve(node.right, max);

        good += left + right;
        return good;
    }
}
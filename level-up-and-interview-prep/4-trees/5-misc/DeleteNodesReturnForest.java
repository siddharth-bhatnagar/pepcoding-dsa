/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int val : to_delete) {
            set.add(val);
        }
        TreeNode n = solve(root, set, ans);
        if (n != null)
            ans.add(n);
        return ans;
    }

    private TreeNode solve(TreeNode node, HashSet<Integer> set, List<TreeNode> ans) {
        if (node == null)
            return null;

        node.left = solve(node.left, set, ans);
        node.right = solve(node.right, set, ans);

        if (set.contains(node.val)) {
            if (node.left != null)
                ans.add(node.left);
            if (node.right != null)
                ans.add(node.right);

            return null;
        }

        return node;
    }
}
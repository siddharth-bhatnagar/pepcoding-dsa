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

// Leetcode 1305
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> io1 = new ArrayList<>();
        List<Integer> io2 = new ArrayList<>();

        dfs(root1, io1);
        dfs(root2, io2);

        if (io1.size() == 0 || io2.size() == 0)
            return io1.size() == 0 ? io2 : io1;

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i != io1.size() && j != io2.size()) {
            int v1 = io1.get(i), v2 = io2.get(j);
            if (v1 < v2) {
                ans.add(v1);
                i++;
            } else {
                ans.add(v2);
                j++;
            }
        }

        while (i != io1.size()) {
            ans.add(io1.get(i));
            i++;
        }

        while (j != io2.size()) {
            ans.add(io2.get(j));
            j++;
        }

        return ans;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
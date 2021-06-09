/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        int height = getHeightEdges(root);
        List<Integer> sm = new ArrayList<>();
        for (int level = 0; level <= height; level++) {
            bfs(root, level, sm);
            ans.add(sm);
            sm = new ArrayList<>();
        }
        return ans;
    }

    public int getHeightEdges(TreeNode node) {
        int h = -1;
        if (node.left != null) {
            int t = getHeightEdges(node.left);
            h = Math.max(h, t);
        }

        if (node.right != null) {
            int t = getHeightEdges(node.right);
            h = Math.max(h, t);
        }
        h++;
        return h;
    }

    public void bfs(TreeNode node, int level, List<Integer> sm) {
        if (node == null)
            return;

        if (level == 0)
            sm.add(node.val);
        else {
            bfs(node.left, level - 1, sm);
            bfs(node.right, level - 1, sm);
        }
    }
}

// O(N*N)
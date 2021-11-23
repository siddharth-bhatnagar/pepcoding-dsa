// GFG
// Complexity: O(N) time, O(N) space
// No contraint on nodes at same VL and HL
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val this.left =
 * left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        // stores min vl and max vl
        int[] arr = new int[2];
        // calculates min and max vl
        widthOfShadow(root, arr, 0);
        // Distance between leftmost and rightmost nodes in tree including both
        int width = arr[1] - arr[0] + 1;

        // Queue for BFS
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, Math.abs(arr[0])));
        // Maintaining the current horizontal level
        // int hl = 0;

        // Initializing the ans arraylist
        for (int i = 0; i < width; i++) {
            ans.add(new ArrayList<>());
        }

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                TreeNode node = rem.node;
                int vl = rem.level;

                ans.get(vl).add(node.val);

                if (node.left != null) {
                    queue.addLast(new Pair(node.left, vl - 1));
                }

                if (node.right != null) {
                    queue.addLast(new Pair(node.right, vl + 1));
                }
            }
        }

        return ans;
    }

    private class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private void widthOfShadow(TreeNode node, int[] arr, int vl) {
        if (node == null)
            return;

        arr[0] = Math.min(arr[0], vl);
        arr[1] = Math.max(arr[1], vl);

        widthOfShadow(node.left, arr, vl - 1);
        widthOfShadow(node.right, arr, vl + 1);
    }
}
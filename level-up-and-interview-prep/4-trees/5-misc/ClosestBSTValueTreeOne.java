// Lintcode 900

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root:   the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        double gap = Double.MAX_VALUE;
        int ans = -1;

        while (root != null) {
            double dif = Math.abs(root.val - target);
            if (dif <= gap) {
                ans = root.val;
                gap = dif;
            }

            if (root.val > target) {
                root = root.left;
            } else if (root.val < target) {
                root = root.right;
            } else {
                return ans;
            }
        }
        return ans;
    }
}
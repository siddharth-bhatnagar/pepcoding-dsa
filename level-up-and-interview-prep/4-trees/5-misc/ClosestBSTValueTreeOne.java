// Lintcode 900

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        closest = root.val;
        difference = Math.abs(target - root.val); 
        findClosest(root, target);
        return closest;
    }

    private double difference;
    private int closest;

    private void findClosest(TreeNode root, double target) {
        if(root == null) return;
        double gap = Math.abs(target - root.val);
        if(gap < difference) {
            difference = gap;
            closest = root.val;
        }

        if(root.val == target) return;

        if(root.val > target) {
            findClosest(root.left, target);
        }
        else if(root.val < target) {
            findClosest(root.right, target);
        }
    }
}
// O(H) time, O(1) space

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param p:    the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        TreeNode curr = root, predecessor = null;

        while (curr != p) {
            if (curr.val < p.val) {
                predecessor = curr;
                curr = curr.right;
            } else if (curr.val > p.val) {
                curr = curr.left;
            }
        }

        curr = curr.left;
        while (curr != null) {
            predecessor = curr;
            curr = curr.right;
        }

        return predecessor;
    }
}
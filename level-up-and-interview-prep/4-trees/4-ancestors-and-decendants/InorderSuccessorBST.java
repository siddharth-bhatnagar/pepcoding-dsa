// Leetcode 285, GFG

// Inorder successor -> Node which comes next in inorder traversal, if no such node exists, return null.
// O(H) time
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    /*
     * @param root: The root of the BST.
     * 
     * @param p: You need find the successor node of p.
     * 
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        TreeNode successor = null;
        TreeNode curr = root;

        while (curr != p) {
            if (curr.val < p.val) {
                curr = curr.right;
            } else if (curr.val > p.val) {
                successor = curr;
                curr = curr.left;
            }
        }

        curr = curr.right;
        while (curr != null) {
            successor = curr;
            curr = curr.left;
        }

        return successor;
    }
}

// O(H) time, O(1) space 
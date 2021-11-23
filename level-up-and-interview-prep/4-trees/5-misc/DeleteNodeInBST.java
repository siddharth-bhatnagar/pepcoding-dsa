/**
 * Leetcode 450
 * 
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root = delete(root);
        }
        return root;
    }

    public TreeNode delete(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null && root.right != null) {
            return root.right;
        } else if (root.right == null && root.left != null) {
            return root.left;
        } else {
            TreeNode leftp1 = root.left;
            while (leftp1.right != null) {
                leftp1 = leftp1.right;
            }
            leftp1.right = root.right;
            return root.left;
        }
    }
}
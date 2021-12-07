/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Leetcode 101
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        else if(n1==null || n2==null) return false;
        
        boolean flag = (n1.val == n2.val) && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
        return flag;
    }
}
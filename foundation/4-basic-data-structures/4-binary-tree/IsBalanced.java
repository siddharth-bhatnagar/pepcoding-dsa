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

//  Leetcode 110
class IsBalanced {
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        helper(root);
        return balanced;
    }
    
    public int helper(TreeNode node) {
        if(node == null) return 0;
        if(balanced) {
            int h = 0;
            int lh = helper(node.left);
            int rh = helper(node.right);
            
            int d = Math.abs(lh - rh);
            if(d > 1) {
                balanced = false;
            }
            
            h = Math.max(lh, rh) + 1;
            return h;
        }
        return -1;
    }
}
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
class Solution {
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        solve(root);
        return maxSum;
    }
    
    private int maxSum;
    private Meta solve(TreeNode node) {
        if(node == null) {
            return new Meta(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        Meta left = solve(node.left);
        Meta right = solve(node.right);
        
        Meta info = new Meta();
        info.bst = left.bst && right.bst && (node.val > left.max && node.val < right.min);
        info.min = Math.min(node.val, Math.min(left.min, right.min));
        info.max = Math.max(node.val, Math.max(right.max, left.max));
        info.sum = left.sum + right.sum + node.val;
        
        if(info.bst) {
            maxSum = Math.max(maxSum, info.sum);
        }
    
        return info;
    }
    
    private class Meta {
        boolean bst;
        int min;
        int max;
        int sum;
        
        public Meta(boolean bst, int min, int max, int sum) {
            this.bst = bst;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
        
        public Meta() {}
    }
}
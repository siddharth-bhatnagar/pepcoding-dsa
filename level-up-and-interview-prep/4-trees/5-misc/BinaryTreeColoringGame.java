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

// Leetcode 1145
// O(N), O(1)
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root, x);
        return Math.max(Math.max(left, right), n-left-right-1) > n/2;
    }
    
    int left;
    int right;
    
    private int find(TreeNode node, int data) {
        if(node == null) return 0;
        
        int l = find(node.left, data);
        int r = find(node.right, data);
        
        if(node.val == data) {
            left = l;
            right = r;
        }
        
        return l + r + 1;
    }
}
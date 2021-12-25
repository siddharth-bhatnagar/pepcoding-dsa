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

// Leetcode 1372
// O(N) time, O(H) space
class Solution {
    public int longestZigZag(TreeNode root) {
        Helper result = solve(root);
        return result.longest - 1;
    }
    
    private Helper solve(TreeNode node) {
        if(node == null) return new Helper(0, 0, 0);
        
        Helper left = solve(node.left);
        Helper right =  solve(node.right);
        
        int l = Math.max(Math.max(left.longest, right.longest), Math.max(left.backward, right.forward) + 1);
        int f = left.backward + 1;
        int b = right.forward + 1;
        
        return new Helper(f, b, l);
    }
    
    private class Helper {
        int forward;
        int backward;
        int longest;
        
        public Helper(int forward, int backward, int longest) {
            this.forward = forward;
            this.backward = backward;
            this.longest = longest;
        }
    }
}

// Another way of writing
class Solution {
    public int longestZigZag(TreeNode root) {
        zigzag = 0;
        
        int left = traversal(root.left, 0);
        int right = traversal(root.right, 1);
        
        
        return Math.max(left+1, Math.max(right+1, zigzag))-1;
    }
    
    private int zigzag;
    private int traversal(TreeNode node, int direction) {
        if(node == null) return 0;
        
        int l = traversal(node.left, 0);
        int r = traversal(node.right, 1);
        
        zigzag = Math.max(l+1, Math.max(r+1, zigzag));
        
        if(direction == 0) {
            return r+1;
        }
        else {
            return l+1;
        }
    }
}
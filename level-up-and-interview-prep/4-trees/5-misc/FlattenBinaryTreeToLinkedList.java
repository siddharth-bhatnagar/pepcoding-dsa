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

//  Leetcode 114
// O(N) time, O(H) space
class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    private TreeNode flat(TreeNode node) {
        if(node == null) return node;
        
        TreeNode leftTail = flat(node.left);
        TreeNode rightTail = flat(node.right);
        
        if(leftTail == null && rightTail == null) {
            return node;    
        }
        else if(leftTail == null) {
            return rightTail;
        }
        else if(rightTail == null) {
            node.right = node.left;
            node.left = null;
            return leftTail;
        }
        else {
            TreeNode lh = node.left;
            TreeNode rh = node.right;
            node.left = null;
            node.right = lh;
            leftTail.right = rh;
            return rightTail;
        }
    }
}


// Approach 2: O(2N) time, O(1) space
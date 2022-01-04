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
// Leetcode 230
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        int val = -1;
        while(node != null) {
            if(node.left != null) {
                TreeNode temp = node.left;
                while(temp.right != null && temp.right != node) temp = temp.right;
                
                if(temp.right == null) {
                    temp.right = node;
                    node = node.left;
                }
                else if(temp.right == node) {
                    if(k==1) {
                        return node.val;
                    }
                    k--;
                    temp.right = null;
                    node= node.right;
                }
            }
            else {
                if(k==1) {
                    return node.val;
                }
                k--;
                node = node.right;
            }
        }
        
        return val;
    }
}
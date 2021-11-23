// Leetcode 144
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

// Time complexity - O(3N), N - 
// Space Complexity - O(1)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        // if root becomes null, it means complete tree traversed
        while(root!=null) {
            // left node hai ki nahi
            if(root.left == null) {
                ans.add(root.val);
                root = root.right;
            }
            // Left node exists
            else {
                // Accessing left node
                TreeNode rootp1 = root.left;
                
                // finding right most node till it becomes null or points to root
                while(rootp1.right != null && rootp1.right != root) {
                    rootp1 = rootp1.right;
                }
                
                // loop broke because of null
                // it means we visited the node first time
                if(rootp1.right == null) {  // 1st time
                    // adding in ans
                    ans.add(root.val);
                    // changing root
                    rootp1.right = root;
                    
                    root = root.left;
                }
                
                else if(rootp1.right == root) {  // 2nd time
                    rootp1.right = null;
                    root = root.right;
                }
            }
        }
        
        return ans;
    }
}

// 
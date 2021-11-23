// Leetcode 94

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
    public List<Integer> inorderTraversal(TreeNode root) {
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
                
                while(rootp1.right != null && rootp1.right != root) {
                    rootp1 = rootp1.right;
                }
                
                if(rootp1.right == null) {  // 1st time
                    
                    rootp1.right = root;
                    root = root.left;
                }

                else if(rootp1.right == root) {  // 2nd time
                    ans.add(root.val);
                    rootp1.right = null;
                    root = root.right;
                }
            }
        }
        
        return ans;
    }
}

/*

Concept behind Morris Traversal in Binary Tree is Threaded Binary Tree. In TBT, we have threads (back edges) from leaf nodes or 
nodes with left != null but right == null towards the inorder successor or the node which should come next in inorder. The right most node
in the tree points to null.

The intuition behind TBT is that in inorder traversal using stack or recursion, we store each child's parent node and when we visit
the parent node for the second time, it implies we have traversed the left subtree and we are coming from right most node of the left subtree.

*/
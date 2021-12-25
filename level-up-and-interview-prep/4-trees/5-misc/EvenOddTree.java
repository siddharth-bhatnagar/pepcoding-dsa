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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                root = queue.removeFirst();
                
                if(level % 2 == 0) {
                    if(root.val % 2 == 0) return false;
                    if(size != 0 && queue.peekFirst().val <= root.val) return false;
                }
                else {
                    if(root.val % 2 != 0) return false;
                    if(size != 0 && queue.peekFirst().val >= root.val) return false;
                }
                
                if(root.left != null) queue.addLast(root.left);
                if(root.right != null) queue.addLast(root.right);
            }
            level++;
        }
              
        return true;
    }
}
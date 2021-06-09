// Leetcode 102

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        List<Integer> sm = new ArrayList<>();

        LinkedList<TreeNode> mq = new LinkedList<>();
        mq.addLast(root);

        while (mq.size() != 0) {
            int size = mq.size();
            while (size-- > 0) {
                TreeNode node = mq.removeFirst();
                sm.add(node.val);
                if (node.left != null)
                    mq.addLast(node.left);
                if (node.right != null)
                    mq.addLast(node.right);
            }
            ans.add(sm);
            sm = new ArrayList<>();
        }
        return ans;
    }
}
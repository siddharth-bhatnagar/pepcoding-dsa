// Leetcode 103
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {

        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (node == null)
            return ans;
        ms.push(node);
        int level = 1;
        while (ms.size() > 0) {
            node = ms.pop();
            list.add(node.val);
            if (level % 2 != 0) {
                if (node.left != null)
                    cs.push(node.left);
                if (node.right != null)
                    cs.push(node.right);
            } else {
                if (node.right != null)
                    cs.push(node.right);
                if (node.left != null)
                    cs.push(node.left);
            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                ans.add(list);
                list = new ArrayList<>();
                level++;
            }

        }
        return ans;
    }
}
// Lintcode 901

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root:   the given BST
     * @param target: the given target
     * @param k:      the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        LinkedList<Integer> ans = new LinkedList<>();
        traversal(root, target, k, ans);
        return ans;
    }

    public static void traversal(TreeNode node, double target, int k, LinkedList<Integer> ans) {
        if (node == null)
            return;

        traversal(node.left, target, k, ans);
        if (ans.size() < k) {
            ans.addLast(node.val);
        } else {
            boolean flag = true;
            if (Math.abs(target - node.val) < Math.abs(target - ans.peekFirst())) {
                ans.removeFirst();
                ans.addLast(node.val);
                flag = false;
            }

            if (flag)
                return;
        }
        traversal(node.right, target, k, ans);
    }
}
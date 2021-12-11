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

    // recursive O(N) time, O(H + k) space
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

// O(N) time, O(k) space
// Using Morris Inorder Traversal
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        if(root == null) {
           window.addLast(0);
           return window;
        }

        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode helper = curr.left;
                while(helper.right != null && helper.right != curr) {
                    helper = helper.right;
                }

                if(helper.right == null) {
                    helper.right = curr;
                    curr = curr.left;
                }
                else if(helper.right == curr) {
                    if(window.size() < k) {
                        window.addLast(curr.val);
                    }
                    else if(Math.abs(target - curr.val) < Math.abs(target - window.peekFirst())) {
                        window.removeFirst();
                        window.addLast(curr.val);
                    }
                    else {
                        return window;
                    }
                    
                    helper.right = null;
                    curr = curr.right;
                }
            }
            else {
                if(window.size() < k) {
                    window.addLast(curr.val);
                }
                else if(Math.abs(target - curr.val) < Math.abs(target - window.peekFirst())) {
                    window.removeFirst();
                    window.addLast(curr.val);
                }
                else {
                    return window;
                }
                curr = curr.right;
            }
        }

        return window;
    }
}
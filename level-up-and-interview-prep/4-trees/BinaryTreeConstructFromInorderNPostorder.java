/**
 * Leetcode 106
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1, map);
    }

    public static TreeNode construct(int[] post, int[] in, int ps, int pe, int is, int ie,
            HashMap<Integer, Integer> map) {
        if (is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(post[pe]);
        int idx = map.get(post[pe]);
        int count = idx - is;

        root.left = construct(post, in, ps, ps + count - 1, is, idx - 1, map);
        root.right = construct(post, in, ps + count, pe - 1, idx + 1, ie, map);

        return root;
    }
}
// Leetcode 105

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// N*N solution
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > is) {
            return null;
        }

        TreeNode node = new TreeNode(pre[ps]);

        int idx = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[ps]) {
                idx = i;
                break;
            }
        }
        int count = idx - is;

        node.left = construct(pre, ps + 1, ps + count, in, is, idx - 1);
        node.right = construct(pre, ps + count + 1, pe, in, idx + 1, ie);

        return node;
    }
}


// O(N)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        
        return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
        if(ps > pe) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[ps]);
        
        // int idx = -1;
        // for(int i=0;i<in.length;i++) {
        //     if(in[i] == pre[ps]){
        //         idx = i;
        //         break;
        //     }
        // }
        // HashMap is used to optimise from O(N*N) to O(N);
        
        int idx = map.get(pre[ps]);
        int count = idx - is;
        
        node.left = construct(pre, ps+1, ps + count,in, is, idx-1, map);
        node.right = construct(pre, ps+count+1, pe,in, idx+1, ie, map);
        
        return node;
    }
}
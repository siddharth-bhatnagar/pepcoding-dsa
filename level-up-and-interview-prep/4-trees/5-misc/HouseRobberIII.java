// Leetcode 337 - House Robber in a binary tree
// O(N) time, O(H) space

class Solution {
    public int rob(TreeNode root) {
        Pair rootPair = robb(root);
        return Math.max(rootPair.with, rootPair.without);
    }

    private Pair robb(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);

        Pair leftPair = robb(root.left);
        Pair rightPair = robb(root.right);

        int w = leftPair.without + rightPair.without + root.val;
        int wo = Math.max(leftPair.with, leftPair.without) + Math.max(rightPair.with, rightPair.without);

        return new Pair(w, wo);
    }

    private class Pair {
        int with;
        int without;

        public Pair(int with, int without) {
            this.with = with;
            this.without = without;
        }
    }
}


// Little bit smarter, prefer below for olt and above for interview
class Solution {
    public int rob(TreeNode root) {
        int[] result = robb(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] robb(TreeNode node) {
        if(node == null) return new int[2];
        
        int[] left = robb(node.left);
        int[] right = robb(node.right);
        
        int[] house = new int[2];
        
        house[0] = left[1] + node.val + right[1];
        house[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return house;
    }
}
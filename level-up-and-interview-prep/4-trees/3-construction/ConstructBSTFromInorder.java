// Leetcode 108
// O(N) time, O(H) space

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return construct(nums, 0, n-1);
    }
    
    private TreeNode construct(int[] nums, int lo, int hi) {
        if(lo > hi) return null;
        
        int mid = (lo+hi)/2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = construct(nums, lo, mid-1);
        node.right = construct(nums, mid+1, hi);
        
        return node;
    }
}
// Leetcode 915
// O(n), O(n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightmin = new int[n];
        rightmin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            rightmin[i] = Math.min(rightmin[i+1], nums[i]);
        }
        
        int leftmax = nums[0];
        for(int i=0;i<n-1;i++) {
            if(leftmax <= rightmin[i+1]) {
                return i+1;
            }
            leftmax = Math.max(leftmax, nums[i+1]);
        }
        
        return -1;
    }
}
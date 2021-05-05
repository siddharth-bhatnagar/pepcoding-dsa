// Leetcode 152

class Solution {
    public int maxProduct(int[] nums) {
        int suffix = 1;
        int prefix = 1;
        int omax = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                prefix = 1;
                omax = Math.max(0, omax);
            }

            if (nums[n - 1 - i] == 0) {
                suffix = 1;
                omax = Math.max(0, omax);
            }

            if (nums[i] != 0) {
                prefix *= nums[i];
                omax = Math.max(prefix, omax);
            }

            if (nums[n - 1 - i] != 0) {
                suffix *= nums[n - i - 1];
                omax = Math.max(suffix, omax);
            }
        }

        return omax;
    }
}
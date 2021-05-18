// Leetcode 1004

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0, count = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 1) {
                count = Math.max(count, j - i + 1);
            } else {
                zeros++;
                while (zeros > k) {
                    if (nums[i] == 0) {
                        zeros--;
                    }
                    i++;
                }
                count = Math.max(count, j - i + 1);
            }
            j++;
        }

        return count;
    }
}
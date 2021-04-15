// Leetcode 849

class Solution {
    public int maxDistToClosest(int[] nums) {
        int ans;
        int i, j;
        i = 0;
        while (nums[i] != 1) {
            i++;
        }
        ans = i;
        j = i + 1;

        while (j < nums.length) {
            if (nums[j] == 0 && j == nums.length - 1) {
                ans = Math.max(ans, j - i);
                return ans;
            } else if (nums[j] == 0) {
                j++;
            } else if (nums[j] == 1) {
                int mid = (j - i) / 2;
                ans = Math.max(ans, mid);
                i = j;
                j = i + 1;
            }
        }

        return ans;
    }
}
// Leetcode # 556
// Next Greater Element III

class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = (n + "").toCharArray();
        int i, j;

        i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        // if nums array is in descending order
        if (i == 0)
            return -1;

        j = i;
        i = i - 1;

        int idx = j;

        while (j < nums.length) {
            if (nums[j] > nums[i] && nums[j] <= nums[idx]) {
                idx = j;
            }
            j++;
        }

        swap(nums, idx, i);
        reverse(nums, i + 1);

        long ans = Long.parseLong(new String(nums));

        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(char[] nums, int i) {
        int si = i;
        int ei = nums.length - 1;
        while (si < ei) {
            swap(nums, si, ei);
            si++;
            ei--;
        }
    }
}

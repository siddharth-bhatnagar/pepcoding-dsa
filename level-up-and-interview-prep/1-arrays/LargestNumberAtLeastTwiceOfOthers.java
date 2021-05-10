// Leetcode 747
class Solution {
    public int dominantIndex(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > largest) {
                secondLargest = largest;
                largest = num;
                idx = i;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        if (largest >= 2 * secondLargest) {
            return idx;
        } else {
            return -1;
        }
    }
}

// Intuition: if the array was sorted, find largest and second largest check the condition
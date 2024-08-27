/*
 * Blog: https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
 * Leetcode 540
 * Brute force approach would be to consider the base cases and iterate over array from 1 to n - 2 and check for individual element.
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];
        int low = 1, high = n - 2;

        // (even, odd) -> Eliminate the left half.
        // (odd, even) -> Eliminate the right half.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            } else if ((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
/*
 * Blog: https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii/
 * Leetcode 81
 *  
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else high = mid - 1;
            }
        }

        return false;
    }
}

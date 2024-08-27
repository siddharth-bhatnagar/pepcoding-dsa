/**
 * Leetcode: 35
 * Blog: https://takeuforward.org/arrays/search-insert-position/
 */

public class SearchInsertPosition {
    // O(Log N), O(1)
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
    }
}
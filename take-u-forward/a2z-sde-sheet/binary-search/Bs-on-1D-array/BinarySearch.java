/**
 * Leetcode: 704
 * Blog: https://takeuforward.org/data-structure/binary-search-explained/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearchIterative(nums, target);
        // return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    // O(logN), O(1)
    private int binarySearchIterative(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
        }

        return -1;
    }

    // O(logN), O(logN)
    private int binarySearchRecursive(int[] nums, int low, int high, int target) {
        // Base Cases
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) return mid;

        if (nums[mid] < target) 
            return binarySearchRecursive(nums, mid + 1, high, target);
        else 
            return binarySearchRecursive(nums, low, mid - 1, target);
    }    
}

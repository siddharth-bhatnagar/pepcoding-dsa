/**
 * https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/
 * leetcode 34
 */
public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target, nums.length);
        int ub = upperBound(nums, target, nums.length);

        if (lb == nums.length || nums[lb] != target) return new int[]{-1, -1};
        return new int[]{lb, ub-1};
    }

    private int[] linear(int[] nums, int x) {
        int[] res = {-1, -1};

        for (int i=0;i<nums.length;i++) {
            if (nums[i] == x && res[0] == -1) {
                res[0] = i;
                res[1] = i;
            } else if (nums[i] == x) res[1] = i;
        }

        return res;
    }

    private int lowerBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (arr[m] >= x) {
                ans = m;
                high = m -1;
            } else low = m + 1;
        }

        return ans;
    }

    private int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (arr[m] > x) {
                ans = m;
                high = m -1;
            } else low = m + 1;
        }

        return ans;
    }

    // Can also be done using normal binary search, in the arr[mid] == x block, just specify the half you want to eliminate    
}

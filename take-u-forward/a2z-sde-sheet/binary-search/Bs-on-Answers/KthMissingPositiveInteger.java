/*
 * Blog: https://takeuforward.org/arrays/kth-missing-positive-number/
 * Leetcode 1539
 */
public class KthMissingPositiveInteger {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return k + high + 1;
    }
}

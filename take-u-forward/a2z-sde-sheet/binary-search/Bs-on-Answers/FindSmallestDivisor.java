/*
 * Blog: https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/
 * Leetcode 1283
 */
public class FindSmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n > threshold) return -1;
        int[] range = getRange(nums);
        int low = 1;
        int high = range[1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(possible(nums, threshold, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int[] getRange(int[] nums) {
        int[] range = new int[2];
        range[0] = Integer.MAX_VALUE;
        range[1] = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            range[0] = Math.min(range[0], nums[i]);
            range[1] = Math.max(range[1], nums[i]);
        }

        return range;
    }
    
    private boolean possible(int[] nums, int threshold, int div) {
        long sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += Math.ceil((double)nums[i] / (double) div);
        }

        return sum <= threshold;
    }
}

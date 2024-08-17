/**
 * Similar to HouseRobber 1, but this time there is circular connection.
 * 0th index and n -1th indices are adjacent
 * Can be solved using considering selective portions of array.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(solve(nums, 0, n-2), solve(nums, 1, n-1));
    }

    private int solve(int[] nums, int s, int e) {
        int p1 = nums[s];
        int p2 = 0;

        for (int i = s + 1; i <= e; i++) {
            int pick = nums[i];
            if (i > 0) pick += p2;
            int notPick = 0 + p1;
            
            int c = Math.max(pick, notPick);
            p2 = p1;
            p1 = c;
        }

        return p1;
    }
}

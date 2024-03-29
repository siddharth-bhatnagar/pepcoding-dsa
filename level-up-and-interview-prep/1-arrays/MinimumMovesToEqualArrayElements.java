// Leetcode 462 
// Minimum moves to equal array elements two

// Strategy, all array elements should become equal to the median
// O(nlogn)

class Solution {
    public int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(median - nums[i]);
        }

        return moves;
    }
}

// Median can be found using quick select in O(n) time in avg case 
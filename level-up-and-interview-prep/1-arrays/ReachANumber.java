// Leetcode 754
// GFG - Number of jumps to reach X

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int moves = 0;
        int i = 1;
        int val = 0;
        while (true) {
            if (val == target) {
                break;
            } else if (val < target) {
                val += i;
                i++;
                moves++;
            } else if (val > target) {
                int d = val - target;
                if (d % 2 == 0) {
                    break;
                }
                val += i;
                i++;
                moves++;
            }
        }

        return moves;
    }
}
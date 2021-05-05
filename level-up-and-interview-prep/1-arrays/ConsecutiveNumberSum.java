// Leetcode 829
// O(N^1/2) time, O(1) space

class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int k = 1; k * k < (2 * N); k++) {
            int div = N - (k * (k - 1)) / 2;
            if (div % k == 0) {
                count++;
            }
        }

        return count;
    }
}
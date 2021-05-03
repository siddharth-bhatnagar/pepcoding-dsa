// Leetcode 370 | Lintcode 903
public class Solution {
    /**
     * @param length:  the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {

        int ans[] = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int i1 = updates[i][0];
            int i2 = updates[i][1];
            int val = updates[i][2];

            ans[i1] += val;
            if (i2 + 1 < length) {
                ans[i2 + 1] -= val;
            }

        }

        // now finding prefix sum of the given array.

        for (int i = 1; i < length; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}
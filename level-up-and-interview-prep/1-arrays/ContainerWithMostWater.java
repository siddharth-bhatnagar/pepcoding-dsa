// Leetcode 11
class Solution {
    public int maxArea(int[] height) {
        int omax = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int storage = (j - i) * Math.min(height[i], height[j]);
            if (storage > omax)
                omax = storage;

            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return omax;
    }
}
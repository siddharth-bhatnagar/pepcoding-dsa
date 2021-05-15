// Leetcode 821
// O(n), O(n)
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int c_pos = -n;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c)
                c_pos = i;
            ans[i] = Math.abs(c_pos - i);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c)
                c_pos = i;
            ans[i] = Math.min(ans[i], Math.abs(c_pos - i));
        }

        return ans;
    }
}
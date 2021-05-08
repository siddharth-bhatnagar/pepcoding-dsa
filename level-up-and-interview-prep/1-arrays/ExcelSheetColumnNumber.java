// Leetcode 171
// O(n), O(1)
class Solution {
    public int titleToNumber(String str) {
        int ans = 0;
        int pow = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int val = str.charAt(i) - 'A' + 1;
            ans += val * pow;
            pow = pow * 26;
        }
        return ans;
    }
}
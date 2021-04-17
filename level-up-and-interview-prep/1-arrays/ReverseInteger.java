// Leetcode 7
class Solution {
    public int reverse(int x) {
        long ans = 0;
        int num = x;

        if (x < 0)
            num = num * (-1);

        while (num != 0) {
            int ld = num % 10;
            num = num / 10;
            ans = ans * 10 + ld;
        }

        if (x < 0)
            ans = ans * (-1);

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;
        else
            return (int) ans;
    }
}
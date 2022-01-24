// Leetcode 8
// O(N) time, O(1) space

class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0)
            return 0;
        int result = 0;
        int i = 0;
        int sign = 1;

        while (i < s.length() && s.charAt(i) == ' ')
            i++;
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+')
            i++;

        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            if ((result > max / 10) || (result == max / 10 && digit > max % 10)) {
                return sign == 1 ? max : min;
            }

            result = result * 10 + digit;
            i++;
        }

        result = result * sign;
        return result;
    }
}
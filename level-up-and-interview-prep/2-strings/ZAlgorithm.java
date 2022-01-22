// Leetcode 28
// Implement Str

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0 || haystack.length() < needle.length())
            return -1;

        String str = needle + "$" + haystack;
        int[] z = Zfunc(str);
        int n = needle.length();

        for (int i = n + 1; i < z.length; i++) {
            if (z[i] == n) {
                return i - n - 1;
            }
        }

        return -1;
    }

    private int[] Zfunc(String str) {
        int n = str.length();
        int[] z = new int[n];

        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            // Giving headstart
            if (i <= R) {
                z[i] = Math.min(z[i - L], R - i + 1);
            }

            // Updating/Trying to extend substring and prefix
            while (i + z[i] < n && str.charAt(i + z[i]) == str.charAt(z[i])) {
                z[i]++;
            }

            // Updating bubble boundary
            if (i + z[i] - 1 > R) {
                L = i;
                R = i + z[i] - 1;
            }
        }

        return z;
    }
} 
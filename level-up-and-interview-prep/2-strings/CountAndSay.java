// Leetcode 38
// O()

class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n - 1);
        int count = 1;
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i))
                count++;
            else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(c);

        return sb.toString();

    }
}
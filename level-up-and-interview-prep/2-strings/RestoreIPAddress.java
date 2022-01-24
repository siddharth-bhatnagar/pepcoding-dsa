// Leetcode 93
// O(3^4) time

class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12)
            return new ArrayList<>();
        List<String> list = new ArrayList<>();
        restore(s, 0, 0, "", list);
        return list;
    }

    private void restore(String s, int i, int dots, String ipv4, List<String> list) {
        if (i == s.length() || dots == 4) {
            if (i == s.length() && dots == 4) {
                list.add(ipv4.substring(0, ipv4.length() - 1));
            }
            return;
        }

        restore(s, i + 1, dots + 1, ipv4 + s.charAt(i) + ".", list);

        if (i + 2 <= s.length() && isValid(s.substring(i, i + 2))) {
            restore(s, i + 2, dots + 1, ipv4 + s.substring(i, i + 2) + ".", list);
        }

        if (i + 3 <= s.length() && isValid(s.substring(i, i + 3))) {
            restore(s, i + 3, dots + 1, ipv4 + s.substring(i, i + 3) + ".", list);
        }
    }

    private boolean isValid(String str) {
        if (str.charAt(0) == '0')
            return false;

        int val = Integer.parseInt(str);
        return val <= 255;
    }
}
// Leetcode 468
// O(N) time

class Solution {
    public String validIPAddress(String queryIP) {
        int n = queryIP.length();
        int cd = 0, cc = 0;
        for (int i = 0; i < n; i++) {
            char ch = queryIP.charAt(i);
            if (ch == '.')
                cd++;
            if (ch == ':')
                cc++;
        }

        if (cd == 3 && queryIP.charAt(n - 1) != '.')
            return ipv4(queryIP);
        else if (cc == 7 && queryIP.charAt(n - 1) != ':')
            return ipv6(queryIP);
        else {
            return "Neither";
        }
    }

    private String ipv4(String s) {
        String[] arr = s.split("\\.");

        for (String chunk : arr) {
            if (chunk.length() == 0 || chunk.length() > 3)
                return "Neither";

            if (chunk.charAt(0) == '0' && chunk.length() != 1)
                return "Neither";

            for (char ch : chunk.toCharArray()) {
                if (ch < '0' || ch > '9')
                    return "Neither";
            }

            if (Integer.parseInt(chunk) > 255)
                return "Neither";
        }

        return "IPv4";
    }

    private String ipv6(String s) {
        String[] arr = s.split(":");
        String hexdigits = "0123456789abcdefABCDEF";

        for (String chunk : arr) {
            if (chunk.length() == 0 || chunk.length() > 4)
                return "Neither";

            for (char ch : chunk.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1)
                    return "Neither";
            }
        }

        return "IPv6";
    }
}
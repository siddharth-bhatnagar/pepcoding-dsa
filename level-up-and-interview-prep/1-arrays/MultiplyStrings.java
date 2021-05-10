// Leetcode 43

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int carryIdx = i + j;
                int valueIdx = i + j + 1;

                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                value = res[valueIdx] + value;
                res[valueIdx] = value % 10;
                res[carryIdx] += value / 10;
            }
        }

        StringBuilder result = new StringBuilder();
      
        for (int i = 0; i < res.length; i++) {
            if (result.length() == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }

        return result.toString();
    }
}
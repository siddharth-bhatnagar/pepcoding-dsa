// Leetcode 273
// O(N) time, O(1) space

class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder res = new StringBuilder();
        int billion = num / 1000000000;
        num = num % 1000000000;
        int million = num / 1000000;
        num = num % 1000000;
        int thousand = num / 1000;
        num = num % 1000;

        if (billion > 0) {
            res.append(three(billion) + "Billion ");
        }

        if (million > 0) {
            res.append(three(million) + "Million ");
        }

        if (thousand > 0) {
            res.append(three(thousand) + "Thousand ");
        }

        res.append(three(num));
        return res.toString().trim();
    }

    private String three(int num) {
        if (num == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        int h = num / 100;
        num = num % 100;
        if (h > 0)
            sb.append(ones[h] + " Hundred ");

        if (num > 0 && num % 10 == 0)
            sb.append(tens[num / 10] + " ");
        else if (num < 20 && num > 10)
            sb.append(lessThanTwenty[num - 10] + " ");
        else if(num > 20) {
            sb.append(tens[num / 10] + " " + ones[num % 10] + " ");
        }
        else if(num > 0) {
            sb.append(ones[num % 10] + " ");
        }

        return sb.toString();
    }

    private String[] ones = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine"
    };

    private String[] tens = {
            "",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    private String[] lessThanTwenty = {
            "",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };
}

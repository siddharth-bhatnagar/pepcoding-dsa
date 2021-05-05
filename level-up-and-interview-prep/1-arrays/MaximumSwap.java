// Leetcode 670
// O(n) time O(n) space approach using suffixmax array
class Solution {
    public int maximumSwap(int num) {
        char[] digits = (num + "").toCharArray();
        int n = digits.length;
        int[] suffixmax = new int[n];
        suffixmax[n-1] = (int)digits[n-1];
        for(int i=n-2;i>=0;i--) {
            suffixmax[i] = Math.max(suffixmax[i+1], digits[i]);
        }
        
        for(int i=0;i<n;i++) {
            if(digits[i] < suffixmax[i]) {
                for(int j=n-1;j>=i+1;j--){
                    if(digits[j]==suffixmax[i]){
                        char temp = digits[i];
                        digits[i] = digits[j];
                        digits[j] = temp;
                        break;
                    }
                }
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }
}

// O(N) time , O(1) space
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
}
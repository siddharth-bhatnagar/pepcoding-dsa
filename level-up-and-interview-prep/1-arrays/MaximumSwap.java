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
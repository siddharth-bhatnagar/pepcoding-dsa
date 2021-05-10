// Leetcode # 556
// Next Greater Element III

class Solution {
    public int nextGreaterElement(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        int i=n-1;
        while(i>0 && digits[i-1] >= digits[i]) {
            i--;
        }
        
        if(i==0) return -1;
                
        int j=i;
        i--;
        int idx = j;
        
        while(j<n) {
            if(digits[i] < digits[j] && digits[j] <= digits[idx]) idx = j;
            j++;
        }
        
        swap(digits, i, idx);
        reverse(digits, i+1);
        
        long ans = Long.parseLong(new String(digits));
        
        return ans > Integer.MAX_VALUE? -1:(int) ans;
    }
    
    public void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
    
    public void reverse(char[] digits, int si) {
        int ei = digits.length-1;
        while(si<ei){
            swap(digits, si, ei);
            si++;
            ei--;
        }
    }
}

/**

- if the digits are in descending order, no ans exists.
- start from the ones place and stop at the next digit smaller in value, lets say at index i.
- then find a digit just larger than the previously found digit in [i+1, end].
- swap the two values.
- sort the digits from i+1 to end.
- check if ans is a 32 bit int, then return -1 or ans.

optimisation: no need to sort the digits, reversing the array from i+1 to end would also work

*/
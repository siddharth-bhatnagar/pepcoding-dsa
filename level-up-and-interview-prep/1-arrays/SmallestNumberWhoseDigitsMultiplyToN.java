// GFG


class Solution {
    static int getSmallest(long n) {
        StringBuilder ans = new StringBuilder();
        if(n<10) {
            return (int)n+10;
        }
        
        for(int i=9;i>=2;i--) {
            if(n%i==0) {
                n=n/i;
                ans.append(i);
                i--;
            }
        }
        
        if(n==1) {
            ans.reverse();
            return Integer.parseInt(ans.toString());
        }
        else {
            return -1;
        }
    }
}
// Leetcode 60

class Solution {

    public String getPermutation(int n, int k) {
        res = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            sb.append(i);
        }
        String num = new String(sb);
        count = 0;
        solve(num, k, "");
        return res;
    }
    
    String res;
    int count;
    public void solve(String str, int k, String asf) {
        if(str.length() == 0) {
            count++;
            if(count == k){
                res = asf;
            }
            
            return;
        }
        
        if(count > k) return;
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i+1);
            solve(ros, k, asf + ch);
        }
    }
}

// This is temp solution, O(N) solution possible using DP or reverse engineering String permutation rank
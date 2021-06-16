// Leetcode 77

class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();        
        int[] spots = new int[k]; 
        solve(0, k, spots, n, 0);
        return list;
    }
    
    public void solve(int cs, int ts, int[] spots, int n, int lsn) {
        if(cs == ts) {
            List<Integer> nl = new ArrayList<>();
            for(int spot: spots) {
                nl.add(spot);
            }
            list.add(nl);
            return;
        }
        
        for(int i=lsn+1;i<=n;i++) {
            spots[cs] = i;
            solve(cs + 1, ts, spots, n, i);
            spots[cs] = 0;
        }
    }
}
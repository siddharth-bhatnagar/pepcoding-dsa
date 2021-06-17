// Leetcode 216

class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        if(k>=n) return list;
        solve(1, k, n, new ArrayList<>(), 0, 0);
        return list;
    }
    
    public void solve(int cn, int k, int sum, List<Integer> comb, int ssf, int amsf) {
        if(ssf == k){
            if(amsf == sum){
                list.add(new ArrayList<>(comb));
            }
            return;
        }
        else if(cn > 9) return;
        
        comb.add(cn);
        solve(cn + 1, k, sum, comb, ssf + 1, amsf + cn);
        comb.remove(comb.size()-1);
        solve(cn + 1, k, sum, comb, ssf + 0, amsf + 0);
    }
}
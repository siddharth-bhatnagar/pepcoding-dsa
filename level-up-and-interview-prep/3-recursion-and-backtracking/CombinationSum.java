// Leetcode 39
// 4ms
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
        if (remain < 0)
            return; 
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < cand.length; i++) {
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}

// 45ms

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] arr, int x) {
        result = new ArrayList<>();
        
        solve(arr, x, 0, 0, "");
        return result;
    }
    
    public void solve(int[] arr, int x, int ci, int amsf, String asf) {
        if(amsf > x) return;
        else if(ci == arr.length) {
            if(amsf == x) {
                List<Integer> sl = new ArrayList<>();
                String[] arrr = asf.split("-");
                for(String ch: arrr) {
                    sl.add(Integer.valueOf(ch));
                }
                result.add(sl);
            }
            return;
        }
        
        for(int i=x/arr[ci];i>=1;i--) {
            StringBuilder sm = new StringBuilder();
            for(int j=0;j<i;j++){
                sm.append(arr[ci] + "-");
            }
            String part = new String(sm);
            solve(arr, x, ci+1, amsf + arr[ci] * i, asf + part);
        }
        solve(arr, x, ci + 1, amsf, asf);
    }
}
// Leetcode 40

class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, new ArrayList<Integer>(), target, 0);
        return list;
    }
    
    public void solve(int[] arr, List<Integer> ans, int target, int start) {
        if(target < 0){
            return;
        }
        else if(target == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }
         
       for(int i=start;i<arr.length;i++) {
            if(i > start && arr[i] == arr[i-1]) continue;
            ans.add(arr[i]);
            solve(arr, ans, target - arr[i], i+1);
            ans.remove(ans.size()-1);  
        }  
    }
}

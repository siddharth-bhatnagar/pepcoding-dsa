// Leetcode 47

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            if (fmap.containsKey(num)) {
                fmap.put(num, fmap.get(num) + 1);
            } else {
                fmap.put(num, 1);
            }
        }

        solve(0, nums.length, fmap, new int[nums.length]);
        return list;
    }

    List<List<Integer>> list;

    public void solve(int cb, int tb, HashMap<Integer, Integer> fmap, int[] spots) {

        if (cb == tb) {
            List<Integer> sm = new ArrayList<>();
            for (int n : spots) {
                sm.add(n);
            }
            list.add(sm);
            return;
        }

        for (int num : fmap.keySet()) {
            if (fmap.get(num) > 0) {
                fmap.put(num, fmap.get(num) - 1);
                spots[cb] = num;
                solve(cb + 1, tb, fmap, spots);
                spots[cb] = 0;
                fmap.put(num, fmap.get(num) + 1);
            }
        }

    }
}
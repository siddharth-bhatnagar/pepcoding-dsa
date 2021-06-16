// Leetcode 47

// Approach 1-Box/Position chooses

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


// Approach two -- Item chooses

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        HashMap<Integer, Integer> lasto = new HashMap<>();
        for(int n: nums) {
            lasto.put(n, -1);
        }
        
        Integer[] spots = new Integer[nums.length];
        
        solve(0, nums, lasto, spots);
        
        return list;
    }
    
    List<List<Integer>> list;
    
    public void solve(int idx, int[] nums, HashMap<Integer, Integer> lasto, Integer[] spots) {
        
        if(idx == nums.length) {
            List<Integer> sm = new ArrayList<>(Arrays.asList(spots));
            list.add(sm);
            return;
        }
        
        int val = nums[idx];
        int lo = lasto.get(val);
        
        for(int i = lo+1;i<spots.length;i++) {
            if(spots[i] == null) {
                spots[i] = val;
                lasto.put(val, i);
                solve(idx + 1, nums, lasto, spots);
                lasto.put(val, lo);
                spots[i] = null;
            }
        }
    }
}
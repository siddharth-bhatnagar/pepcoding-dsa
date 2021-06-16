// Leetcode 46

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        int[] spots = new int[nums.length];
        Arrays.fill(spots, -11);
        permutations(0, nums.length, spots, nums);
        return list;
    }

    List<List<Integer>> list;

    public void permutations(int ci, int ti, int[] spots, int[] nums) {
        if (ci == ti) {
            List<Integer> sm = new ArrayList<>();
            for (int spot : spots) {
                sm.add(spot);
            }
            list.add(sm);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (spots[i] == -11) {
                spots[i] = nums[ci];
                permutations(ci + 1, ti, spots, nums);
                spots[i] = -11;
            }
        }
    }
}
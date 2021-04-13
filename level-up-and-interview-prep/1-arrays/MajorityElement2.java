// Leetcode 229
//  Boyer moore modified
// O(2n) time O(1) space
// 3 distinct element pairing

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();
        int v1 = nums[0], v2 = nums[0], c1 = 1, c2 = 0;

        for (int i = 1; i < nums.length; i++) {
            if (v1 == nums[i]) {
                c1++;
            } else if (v2 == nums[i]) {
                c2++;
            } else if (c1 == 0) {
                v1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                v2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        int f1 = 0, f2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == v1)
                f1++;
            if (nums[i] == v2)
                f2++;
        }

        if (f1 > nums.length / 3)
            list.add(v1);

        if (v1 != v2 && f2 > nums.length / 3)
            list.add(v2);

        return list;
    }
}
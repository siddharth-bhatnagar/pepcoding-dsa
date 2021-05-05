// Leetcode 1

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int def = target - num;

            if (map.containsKey(def)) {
                int pos = map.get(def);
                ans[0] = pos;
                ans[1] = i;
                break;
            }

            map.put(num, i);
        }
        return ans;
    }
}

/**
 * O(nlogn) approach using sorting 
 * 
 * Arrays.sort(nums);
 * int i=0, j=nums.length-1;
 * while(i<j){
 *      if(nums[i] + nums[j] == target) {
 *          return true;
 *      }
 *      else if(nums[i] + nums[j] < target) {
 *          i++;
 *      }
 *      else {
 *          j--;
 *      }
 * }
 * 
 * return false;
 */
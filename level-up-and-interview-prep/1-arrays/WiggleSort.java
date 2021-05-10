// Leetcode 280 Premium problem
// Lintcode 508

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here 
        for(int i=0;i<nums.length-1;i++){
            if((i%2==0 && nums[i] >= nums[i+1]) || (i%2!=0 && nums[i] <= nums[i+1])){
                int t = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = t;
            }
        }
    }
}
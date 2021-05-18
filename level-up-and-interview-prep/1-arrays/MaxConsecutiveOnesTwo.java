// Lintcode 883
// Leetcode 487

public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
       int zeros = 0, count = 0;
       int i=0, j =0;
       while(j<nums.length) {
           if(nums[j] == 1) {
               count = Math.max(count, j-i+1);
           }
           else {
               zeros++;
               while(zeros>1) {
                   if(nums[i] == 0) {
                       zeros--;
                   }
                   i++;
               }
               count = Math.max(count, j-i+1);
           }
           j++;
       }

       return count;
    }
}
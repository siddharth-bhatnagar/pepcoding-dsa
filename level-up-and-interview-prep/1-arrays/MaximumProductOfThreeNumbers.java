// Leetcode 628
class Solution {
    public int maximumProduct(int[] nums) {
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            
            if(num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }
            else if(num>max2){
                max3=max2;
                max2=num;
            }
            else if(num>max3){
                max3=num;
            }
            
            if(num<min1){
                min2=min1;
                min1=num;
            }
            else if(num<min2){
                min2=num;
            }
        }
  
        int prod1 = max1*max2*max3;
        int prod2 = min1*min2*max1;
        
        return Math.max(prod1, prod2);
    }
}


/**
Intuition
If the array was sorted, find, largest, second largest and third largest as well as smallest and second smallest and find the respected products
Compare and return ans.
*/
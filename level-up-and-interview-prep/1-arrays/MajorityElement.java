// leetcode 169

// Boyer Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++) {
            if(val==nums[i]) {
                count++;
            }
            else if(count == 0) {
                val = nums[i];
                count=1;
            }
            else {
                count--;
            }
        }
        
        return val;
    }
}

/** 
Brute Force

for(i=0 to n-1){}
    int val=arr[i];
    int c=0;
    for(j=0 to n-1){
        if(val==arr[j]) c++;
    }
    
    if(c>n/2)
        return val;
}

return -1;

O(n^2), O(1)

Better 

Arrays.sort(arr);
return arr[n/2];

(nlogn), O(1)

Optimal - Boyer moore voting algorithm
O(n),O(1)
*/
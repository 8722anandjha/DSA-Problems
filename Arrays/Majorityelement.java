/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.
 
*/

// Brute force-O(n2)
class Solution {
    public int majorityElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]== nums[j]){
                    count++;
                }
            }
            if(count > nums.length/2) return nums[i];
        }
        return -1;
    }
}

// Optimal O(n)
class Solution2 {
    public int majorityElement(int[] nums) {
       int candidate= nums[0];
       int count=1;
       for(int i=1;i< nums.length;i++){
        if(nums[i] == candidate){
            count++;
        }else{
            count--;
        }

        if(count ==0){
            candidate= nums[i];
            count=1;
        }
       }
       return candidate;
    }
}
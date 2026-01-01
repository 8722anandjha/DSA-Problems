/* Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

// code
class Solution {
    public void rotate(int[] nums, int k) {
        int n= k% nums.length;
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0,n-1);
        reverseArray(nums,n,nums.length-1);
    }
    public void reverseArray(int[] nums,int start,int end ){
        int i= start;
        int j= end;
        while(i< j){
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
            i++;
            j--;
        }
    }
}
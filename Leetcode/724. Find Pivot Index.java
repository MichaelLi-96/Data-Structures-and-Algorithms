//https://leetcode.com/problems/find-pivot-index/

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == (totalSum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
/*
    Time Complexity: O(2n) -> O(n) where n is the length of the input array nums
    Space Complexity: O(1)
*/
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int index = 1;
        int currentNum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != currentNum) {
                nums[index] = nums[i];
                index++;
                currentNum = nums[i];
            }
        }
        return index;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input array nums
	Space Complexity: O(1)
*/
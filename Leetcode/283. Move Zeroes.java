//https://leetcode.com/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[p2] != 0) {
                swap(p1, p2, nums);
                p1++;
            }
            p2++;
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input int[] nums
	Space Complexity: O(1)
*/
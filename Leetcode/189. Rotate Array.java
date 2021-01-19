//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
    }
}


/*
    Time Complexity: O(n) where n is the length of the input int array nums
    Space Complexity: O(n) where n is the length of the input int array nums
*/
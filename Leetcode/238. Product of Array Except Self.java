//https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arrA = new int[nums.length];
        int[] arrB = new int[nums.length];
        
        arrA[0] = 1;
        arrB[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++) {
            arrA[i] = arrA[i - 1] * nums[i - 1];
        }
        
        for(int i = nums.length - 2; i >= 0; i--) {
            arrB[i] = arrB[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = arrA[i] * arrB[i];
        }
        return nums;
    }
}

/*
	Time Complexity: O(3n) -> O(n) where n is the length of the input nums array
	Space Complexity: O(2n) -> O(n) where n is the length of the input nums array 
*/
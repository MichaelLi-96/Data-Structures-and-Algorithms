//https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        boolean[] numbers = new boolean[nums.length + 1];
        for(int num : nums) {
            numbers[num] = true;
        }
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == false) {
                return i;
            }
        }
        
        return -1;
    }
}


/*
	Time Complexity: O(2n) -> O(n) where n is the length of the array 
	Space Complexity: O(n + 1) -> O(n) where n is the length of the array 
*/
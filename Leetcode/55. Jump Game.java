//https://leetcode.com/problems/perfect-squares/

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] jumpable = new boolean[nums.length];
        jumpable[0] = true;
        for(int i = 1; i < jumpable.length; i++) {
            for(int j = 0; j < i; j++) {
                if(jumpable[j] == true && j + nums[j] >= i) {
                    jumpable[i] = true;
                }
            }
        }
        return jumpable[jumpable.length - 1];
    }
}

/*
	Time Complexity: O(n^2) where n is the length of the input int array nums
	Space Complexity: O(n) where n is the length of the input int array nums
*/

class Solution {
    public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array nums
    Space Complexity: O(1)
*/

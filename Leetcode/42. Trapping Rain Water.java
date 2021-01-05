//https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int sum = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left];
                left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array height
    Space Complexity: O(1)
*/

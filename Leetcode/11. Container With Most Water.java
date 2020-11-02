//https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        while(left < right) {
            if(height[left] <= height[right]) {
                int area = height[left] * (right - left);
                max = Math.max(max, area);
                left++;
            }
            else {
                int area = height[right] * (right - left);
                max = Math.max(max, area);
                right--;
            }
        }
        return max;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input height array
    Space Complexity: O(1)
*/
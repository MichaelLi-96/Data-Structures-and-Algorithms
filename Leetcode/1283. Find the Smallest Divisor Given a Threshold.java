//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/submissions/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for(int num : nums) {
                sum += Math.ceil(Double.valueOf(num) / Double.valueOf(mid));
            }
            if(sum > threshold) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/*
	Time Complexity: O(mlog(n)) where m is the length of the input nums array and n is the right boundary maximum for a divisor
	Space Complexity: O(1)
*/
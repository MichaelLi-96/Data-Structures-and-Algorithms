//https://leetcode.com/problems/monotonic-array/

class Solution {
    public boolean isMonotonic(int[] A) {
        int prev = A[0];
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 1; i < A.length; i++) {
            if(prev > A[i]) {
                increasing = false;
            }
            if(prev < A[i]) {
                decreasing = false;
            }
            prev = A[i];
        }
        return increasing || decreasing;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array A 
    Space Complexity: O(1)
*/

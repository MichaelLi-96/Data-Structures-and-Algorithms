//https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length / 4;
        for(int i = 0; i < arr.length - len; i++) {
            if(arr[i] == arr[i + len]) {
                return arr[i];
            }
        }
        return -1;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array
    Space Complexity: O(1)
*/
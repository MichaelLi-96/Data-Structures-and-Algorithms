//https://leetcode.com/problems/valid-mountain-array/

class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        int max = arr[0];
        int peakIndex = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                peakIndex = i;
            }
        }
        
        if(peakIndex == 0 || peakIndex == arr.length - 1) {
            return false;
        }

        int leftIndex = peakIndex - 1;
        int prev = max;
        while(leftIndex >= 0) {
            if(arr[leftIndex] >= prev) {
                return false;
            }
            prev = arr[leftIndex];
            leftIndex--;
        }

        int rightIndex = peakIndex + 1;
        prev = max;
        while(rightIndex < arr.length) {
            if(arr[rightIndex] >= prev) {
                return false;
            }
            prev = arr[rightIndex];
            rightIndex++;
        }

        return true;
    }
}

/*
    Time Complexity: O(2n) -> O(n) where n is the length of input array arr
    Space Complexity: O(1)
*/
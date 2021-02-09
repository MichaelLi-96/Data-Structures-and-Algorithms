//https://leetcode.com/problems/duplicate-zeros/

class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                rightShiftTillIndex(arr, i);
                i++;
            }
        }
    }
    
    public void rightShiftTillIndex(int[] arr, int idx) {
        for(int i = arr.length - 1; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
    }
}

/*
	Time Complexity: O(n^2) where n is the length of the input array arr
	Space Complexity: O(1)
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            }
        }
        int j = arr.length + zeroCount - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] != 0) {
                if(j <= arr.length - 1) {
                    arr[j] = arr[i];
                }
            }
            else {
                if(j <= arr.length - 1) {
                    arr[j] = arr[i];
                }
                j--;
                if(j <= arr.length - 1) {
                    arr[j] = arr[i];
                }
            }
            j--;
        }
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array arr
    Space Complexity: O(1)
*/
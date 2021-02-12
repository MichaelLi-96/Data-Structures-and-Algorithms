//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int greatestElement = -1;
            for(int j = i + 1; j < arr.length; j++) {
                greatestElement = Math.max(greatestElement, arr[j]);
            }
            arr[i] = greatestElement;
        }
        return arr;
    }
}

/*
    Time Complexity: O(n^2) where n is the length of the input int array  
    Space Complexity: O(1)
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int curNum = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] < curNum) {
                arr[i] = curNum;
            }
            else {
                int temp = curNum;
                curNum = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array  
    Space Complexity: O(1)
*/
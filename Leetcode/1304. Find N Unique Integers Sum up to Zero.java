//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int start = 0;
        int end = n - 1;
        int num = n / 2;
        while(start < end) {
            arr[start] = -num;
            arr[end] = num;
            start++;
            end--;
            num--;
        }
        return arr;
    }
}

/*
    Time Complexity: O(log(n)) where n is the int input n
    Space Complexity: O(1), O(n) counting output array where n is the int input n
*/

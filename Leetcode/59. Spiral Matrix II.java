//https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] outputArr = new int[n][n];
        int currentNum = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int dir = 1;
        while(top <= bottom && left <= right) {
            if(dir == 1) {
                for(int i = left; i <= right; i++) {
                    outputArr[top][i] = currentNum;
                    currentNum++;
                }
                top++;
                dir++;
            }
            else if(dir == 2) {
                for(int i = top; i <= bottom; i++) {
                    outputArr[i][right] = currentNum;
                    currentNum++;
                }
                right--;
                dir++;
            }
            else if(dir == 3) {
                for(int i = right; i >= left; i--) {
                    outputArr[bottom][i] = currentNum;
                    currentNum++;
                }
                bottom--;
                dir++;
            }
            else if(dir == 4) {
                for(int i = bottom; i >= top; i--) {
                    outputArr[i][left] = currentNum;
                    currentNum++;
                }
                left++;
                dir = 1;
            }
        }
        return outputArr;
    }
}

/*
	Time Complexity: O(n^2) where n is the input int n
	Space Complexity: O(1) not counting output matrix, O(n^2) counting output matrix where n is the input int n
*/
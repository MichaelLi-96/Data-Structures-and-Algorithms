//https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            int val = matrix[row][col];
            if(target == val) {
                return true;
            }
            else if(target < val) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}

/*
	Time Complexity: O(n + m) where n is the number of rows and m is the number of columns in the input matrix 
	Space Complexity: O(1)
*/
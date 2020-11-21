//https://leetcode.com/problems/toeplitz-matrix/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
    Time Complexity: O(n) where n is the number of elements in the input matrix
    Space Complexity: O(1)
*/

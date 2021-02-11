//https://leetcode.com/problems/transpose-matrix/

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}
/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix 
    Space Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix 
*/
//https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length / 2; i++) {
            for(int j = i; j < matrix[0].length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix[0].length - 1 - j];
                matrix[matrix.length - 1 - i][matrix[0].length - 1 - j] = matrix[j][matrix[0].length - 1 - i];
                matrix[j][matrix[0].length - 1 - i] = temp;
            }
        }
    }
}

/*
    Time Complexity: O(n^2) where n is the length of the input matrix
    Space Complexity: O(1) 
*/
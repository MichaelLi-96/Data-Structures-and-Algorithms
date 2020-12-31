//https://leetcode.com/problems/count-square-submatrices-with-all-ones/

class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int squareCount = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    squareCount += dp[i][j];
                }
                else {
                    dp[i][j] = matrix[i][j];
                    squareCount += matrix[i][j];
                }
            }
        }
       
        return squareCount;
    }
}

/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix 
    Space Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix 
*/

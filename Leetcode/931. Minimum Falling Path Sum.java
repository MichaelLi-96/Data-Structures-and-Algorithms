//https://leetcode.com/problems/minimum-falling-path-sum/

class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                int minSum = A[i][j] + A[i - 1][j];
                if(j != 0) {
                    minSum = Math.min(minSum, A[i][j] + A[i - 1][j - 1]);
                }
                if(j != A[0].length - 1) {
                    minSum = Math.min(minSum, A[i][j] + A[i - 1][j + 1]);
                }
                A[i][j] = minSum;
            }
        }
        
        int minPathSum = A[A.length - 1][0];
        for(int i = 0; i < A[0].length; i++) {
            minPathSum = Math.min(minPathSum, A[A.length - 1][i]);
        }
      
        return minPathSum;
    }
}

/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix A
    Space Complexity: O(1)
*/

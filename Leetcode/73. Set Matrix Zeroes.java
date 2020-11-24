//https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean top = false;
        boolean left = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) {
                        top = true;
                    }
                    if(j == 0) {
                        left = true;
                    }
                    if(i >= 1 && j >= 1) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if(left) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(top) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }   
        }
    }
}

/*
	Time Complexity: O(n) where is the number of elements in the input matrix
	Space Complexity: O(1)
*/
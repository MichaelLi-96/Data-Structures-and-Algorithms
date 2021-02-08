//https://leetcode.com/problems/number-of-enclaves/

class Solution {
    public int numEnclaves(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            deleteBoundaryIslands(i, 0, A);
            deleteBoundaryIslands(i, A[0].length - 1, A);
        }
        for(int i = 0; i < A[0].length; i++) {
            deleteBoundaryIslands(0, i, A);
            deleteBoundaryIslands(A.length - 1, i, A);
        }
        int total = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    total += 1;
                }
            }
        }
        return total;
    }
    
    public void deleteBoundaryIslands(int i, int j, int[][] A) {
        if(i < 0 || j < 0 || i == A.length || j == A[0].length || A[i][j] == 0) {
           return;
        }
        if(A[i][j] == 1) {
            A[i][j] = 0;
        }
        deleteBoundaryIslands(i + 1, j, A);
        deleteBoundaryIslands(i - 1, j, A);
        deleteBoundaryIslands(i, j + 1, A);
        deleteBoundaryIslands(i, j - 1, A);
    }
}

/*
	Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix A
	Space Complexity: O(1) auxiliary  space, O(n * m) stack space where n is the number of rows and m is the number of columns in the input matrix A
*/
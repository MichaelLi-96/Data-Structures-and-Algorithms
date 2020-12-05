//https://leetcode.com/problems/matrix-diagonal-sum/

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i = 0; i < mat.length / 2; i++) {
            sum += mat[i][i];
            sum += mat[i][mat[0].length - 1 - i];  
            sum += mat[mat.length - 1 - i][i];
            sum += mat[mat.length - 1 - i][mat[0].length - 1 - i];
        }
        if(mat.length % 2 == 1) {
            sum += mat[mat.length / 2][mat.length / 2];    
        }
        
        return sum;
    }
}

/*
	Time Complexity: O(n/2) -> O(n) where n is the length of the input matrix mat  
	Space Complexity: O(1)
*/


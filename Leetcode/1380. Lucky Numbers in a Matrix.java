//https://leetcode.com/problems/lucky-numbers-in-a-matrix/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            int idx1 = i;
            int idx2 = 0;
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] < matrix[idx1][idx2]) {
                    idx1 = i;
                    idx2 = j;
                }
            }
            matrix[idx1][idx2] = -matrix[idx1][idx2];
        }
        
        for(int i = 0; i < matrix[0].length; i++) {
            int idx1 = i;
            int idx2 = 0;
            for(int j = 1; j < matrix.length; j++) {
                if(Math.abs(matrix[j][i]) > Math.abs(matrix[idx2][idx1])) {
                    idx1 = i;
                    idx2 = j;
                }
            }
            if(matrix[idx2][idx1] < 0) {
                list.add(Math.abs(matrix[idx2][idx1]));
            }
        }

        return list;
    }
}


/*
	Time Complexity: O(n) where n is the number of elements in the input matrix
	Space Complexity: O(1) not counting the output arraylist, O(n) where n is the length of the matrix row counting the output arraylist
*/
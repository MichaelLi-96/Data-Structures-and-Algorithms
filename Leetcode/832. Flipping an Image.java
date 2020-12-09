//https://leetcode.com/problems/flipping-an-image/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int[] row = A[i];
            
            // Invert
            for(int j = 0; j < row.length; j++) {
                if(row[j] == 0) {
                    row[j] = 1;
                }
                else {
                    row[j] = 0;
                }
            }
            
            // Reverse
            int start = 0;
            int end = row.length - 1;
            while(start <= end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }
        return A;
    }
}

/*
	Time Complexity: O(n * 2m) -> O(n * m) where n is the number of rows and m is the number of columns in the input matrix A
	Space Complexity: O(1)
*/
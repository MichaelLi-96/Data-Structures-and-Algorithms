//https://leetcode.com/problems/path-with-maximum-gold/

class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, returnMaxPath(i, j, grid));
            }
        }
        return max;
    }
    
    public int returnMaxPath(int i, int j, int[][] grid) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        int left = returnMaxPath(i, j - 1, grid);
        int right = returnMaxPath(i, j + 1, grid);
        int top = returnMaxPath(i + 1, j, grid);
        int bottom = returnMaxPath(i - 1, j, grid);
        grid[i][j] = temp;
        return temp + Math.max(left, Math.max(right, Math.max(top, bottom)));
    }
}

/*
    Time Complexity: O(n*m*4^(n*m)) where n is the number of rows and m is the number of columns in the input matrix grid
    Space Complexity: O(1) auxiliary space, O(n*m) stack space
*/

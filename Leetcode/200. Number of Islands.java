//https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                num += deleteIsland(i, j, grid);
            }
        }
        return num;
    }
    
    public int deleteIsland(int i, int j, char[][] grid) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        deleteIsland(i + 1, j, grid);
        deleteIsland(i - 1, j, grid);
        deleteIsland(i, j + 1, grid);
        deleteIsland(i, j - 1, grid);
        return 1;
    }
}

/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix grid
    Space Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix grid
*/

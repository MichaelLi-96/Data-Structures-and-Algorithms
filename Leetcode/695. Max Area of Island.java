//https://leetcode.com/problems/max-area-of-island/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, findIslandArea(i, j, grid));
            }
        }
        return max;
    }
    
    public int findIslandArea(int i, int j, int[][] grid) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += findIslandArea(i + 1, j, grid);
        area += findIslandArea(i - 1, j, grid);
        area += findIslandArea(i, j + 1, grid);
        area += findIslandArea(i, j - 1, grid);
        return area;
    }
}

/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix grid
    Space Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix grid
*/

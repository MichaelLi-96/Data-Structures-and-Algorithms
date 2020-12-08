//https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] paths = new int[grid.length][grid[0].length];
        paths[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            paths[i][0] = grid[i][0] + paths[i - 1][0]; 
        }
        for(int i = 1; i < grid[0].length; i++) {
            paths[0][i] = grid[0][i] + paths[0][i - 1]; 
        }
        
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                paths[i][j] = Math.min(paths[i - 1][j] + grid[i][j], paths[i][j - 1] + grid[i][j]);
            }
        }
        
        return paths[paths.length - 1][paths[0].length - 1];
    }
}

/*
    Time Complexity: O(n + m + (n * m)) -> O(n*m) where n is the number of rows and m is the number of columns of the input matrix grid
    Space Complexity: O(n*m) where n is the number of rows and m is the number of columns of the input matrix grid
*/
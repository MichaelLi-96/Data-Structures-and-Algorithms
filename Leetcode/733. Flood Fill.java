//https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    public void fill(int[][] image, int row, int col, int oldColor, int newColor) {
        if(row < 0 || row == image.length || col < 0 || col == image[0].length || image[row][col] != oldColor || image[row][col] == newColor) {
            return;
        }
        image[row][col] = newColor;
        fill(image, row + 1, col, oldColor, newColor);
        fill(image, row - 1, col, oldColor, newColor);
        fill(image, row, col + 1, oldColor, newColor);
        fill(image, row, col - 1, oldColor, newColor);
    }
}

/*
	Time Complexity: O(n) where n is the number of elements in the matrix
	Space Complexity: O(n) where n is the number of elements in the matrix
*/
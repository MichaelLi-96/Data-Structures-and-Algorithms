//https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        for(int i = 0; i < board.length; i++) {
            setBoundaries(board, i, 0);
            setBoundaries(board, i, board[0].length - 1);
        }
        
        for(int i = 0; i < board[0].length; i++) {
            setBoundaries(board, 0, i);
            setBoundaries(board, board.length - 1, i);
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void setBoundaries(char[][] board, int i, int j) {
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }
        if(board[i][j] == 'O') {
            board[i][j] = '*';
        }
        setBoundaries(board, i - 1, j);
        setBoundaries(board, i + 1, j);
        setBoundaries(board, i, j - 1);
        setBoundaries(board, i, j + 1);
    }
}

/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix board
    Space Complexity: O(1) auxiliary  space, O(n * m) stack space where n is the number of rows and m is the number of columns in the input matrix A
*/
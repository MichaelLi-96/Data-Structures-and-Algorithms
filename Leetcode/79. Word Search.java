//https://leetcode.com/problems/word-search/

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
           for(int j = 0; j < board[0].length; j++) {
               if(backtracking(i, j, board, 0, word))  {
                   return true;
               }
           }
        }
        return false;
    }
    
    public boolean backtracking(int i, int j, char[][] board, int currentIndex, String word) {
        if(currentIndex == word.length()) {
            return true;
        }
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == '0' || board[i][j] != word.charAt(currentIndex)) {
            return false;
        }
        Character temp = board[i][j];
        board[i][j] = '0';
        if(backtracking(i - 1, j, board, currentIndex + 1, word) ||
           backtracking(i + 1, j, board, currentIndex + 1, word) ||
           backtracking(i, j - 1, board, currentIndex + 1, word) ||
           backtracking(i, j + 1, board, currentIndex + 1, word)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}

/*
    Time Complexity: O(n * m * 4^l) where n is the number of rows and m is the number of columns in the input char matrix board and l is the length of the input string word
    Space Complexity: O(1) auxiliary space, O(l) where l is the length of the input string word stack space
*/
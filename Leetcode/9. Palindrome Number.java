//https://leetcode.com/problems/palindrome-number/submissions/

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;    
        }
        int xCopy = x;
        int reversedX = 0;
        while(xCopy != 0) {
            int digit = xCopy % 10;
            xCopy = xCopy / 10;
            reversedX = reversedX * 10;
            reversedX += digit;
        }
        return x == reversedX;
    }
}

/*
    Time Complexity: O(n) where n is the number of digits in the input x     
    Space Complexity: O(1)
*/
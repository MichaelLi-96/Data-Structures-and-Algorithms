//https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1; 
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string s
    Space Complexity: O(1)
*/
//https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            else {
                if(s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}

/*
	Time Complexity: O(n) where n is the length of input string s
	Space Complexity: O(1)
*/
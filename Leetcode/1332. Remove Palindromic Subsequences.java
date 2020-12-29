//https://leetcode.com/problems/remove-palindromic-subsequences/

class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else {
                return 2;
            }
        }
        return 1;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string S
    Space Complexity: O(1)
*/

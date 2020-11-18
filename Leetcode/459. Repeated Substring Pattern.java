//https://leetcode.com/problems/repeated-substring-pattern/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i <= s.length() / 2; i++) {
            if(s.length() % i == 0) {
                String substring = s.substring(0, i);
                int currentIndex = 0;
                for(int j = 0; j < s.length(); j++) {
                    if(substring.charAt(currentIndex) != s.charAt(j)) {
                        break;
                    }
                    currentIndex++;
                    if(currentIndex == substring.length()) {
                        if(j == s.length() - 1) {
                            return true;
                        }                    
                        currentIndex = 0;
                    }
                }
            }
        }
        return false;
    }
}

/*
    Time Complexity: O(n^2) where n is the length of input String s
    Space Complexity: O(1)
*/
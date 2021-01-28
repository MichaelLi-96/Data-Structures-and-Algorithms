//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String str1 = spreadAroundCenter(s, i, i);
            String str2 = spreadAroundCenter(s, i, i + 1);
            if(str1.length() > longest.length()) {
                longest = str1;
            }
            if(str2.length() > longest.length()) {
                longest = str2;
            }
        }
        return longest;
    }
    
    public String spreadAroundCenter(String s, int i, int j) {
        StringBuilder str = new StringBuilder();
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if(i == j) {
                str.append(s.charAt(i));
            }
            else {
                str.insert(0, s.charAt(i));
                str.append(s.charAt(j));
            }
            i--;
            j++;
        }
        return str.toString();
    }
}

/*
	Time Complexity: O(n^2) where n is the length of the input String s
	Space Complexity: O(1)
*/
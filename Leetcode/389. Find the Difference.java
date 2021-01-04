//https://leetcode.com/problems/find-the-difference/

class Solution {
    public char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            if(--alphabet[t.charAt(i) - 'a'] == -1) {
                return t.charAt(i);
            }
        }
      
        return 0;
    }
}
/*
    Time Complexity: O(n + m) where n is the length of the input string s and m is the length of the input string t
    Space Complexity: O(1) because the size of the alphabet array will remain constant despite varying inputs
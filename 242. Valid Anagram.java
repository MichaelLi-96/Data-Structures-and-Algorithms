//https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            letters[ch - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            letters[ch - 'a']--;
        }
        
        for(int i = 0; i < letters.length; i++) {
            if(letters[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}

/*
	Time Complexity: O(s + t + n) where s is the length of string s, t is the length of string t, and n is the length of the letters array
	Space Complexity: O(1) because the size of the letters array remains constant no matter the size of the input strings 
*/ 
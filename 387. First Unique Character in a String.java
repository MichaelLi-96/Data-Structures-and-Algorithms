//https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            letters[ch - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(letters[ch - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}


/*
	Time Complexity: O(2(n)) -> O(n) where n is the length of String s
	Space Complexity: O(1) because the letters array will have length of 26 no matter what input is supplied
*/
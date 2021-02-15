//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] letterCounts = new int[26];
        for(int i = 0; i < chars.length(); i++) {
            Character ch = chars.charAt(i);
            letterCounts[ch - 'a']++;
        }
        int sum = 0;
        for(String word : words) {
            int[] wordLetters = new int[26];
            for(int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                wordLetters[ch - 'a']++;
            }
            boolean canBeFormed = true;
            for(int i = 0; i < 26; i++) {
                if(wordLetters[i] > letterCounts[i]) {
                    canBeFormed = false;
                }
            }
            if(canBeFormed) {
                sum += word.length();
            }
        }
        return sum;
    }
}
/*
    Time Complexity: O(n * m) where n is the length of the input String array words and m is the length of the longest word in the words array
    Space Complexity: O(1) because we are making an array of length 26 everytime despite differing size inputs 
*/
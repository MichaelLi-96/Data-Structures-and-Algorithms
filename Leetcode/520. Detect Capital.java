//https://leetcode.com/problems/detect-capital/

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean allCaps = true;
        boolean noCaps = true;
        boolean firstLetter = true;
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(Character.isLowerCase(letter)) {
                allCaps = false;
            }
            if(Character.isUpperCase(letter)) {
                noCaps = false;
            }
            if(Character.isLowerCase(word.charAt(0)) || (i > 0 && Character.isUpperCase(letter))) {
                firstLetter = false;
            }
        }
        return allCaps || noCaps || firstLetter;
    }
        
}

/*
	Time Complexity: O(n) where n is the length of the input string word 
	Space Complexity: O(1)
*/
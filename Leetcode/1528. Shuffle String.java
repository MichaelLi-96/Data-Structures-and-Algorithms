//https://leetcode.com/problems/shuffle-string/

class Solution {
    public String restoreString(String s, int[] indices) {
        Character[] shuffledArr = new Character[s.length()];
        for(int i = 0; i < indices.length; i++) {
            shuffledArr[indices[i]] = s.charAt(i);
        }
        StringBuilder shuffledString = new StringBuilder();
        for(Character ch : shuffledArr) {
            shuffledString.append(ch);
        }
        return shuffledString.toString();
    }
}

/*
	Time Complexity: O(n) where n is the length of the input string s
	Space Complexity: O(n) where n is the length of the input string s
*/
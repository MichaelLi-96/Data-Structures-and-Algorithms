//https://leetcode.com/problems/maximum-number-of-balloons/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] letters = new int[26];
        for(int i = 0 ; i < text.length(); i++) {
            letters[text.charAt(i) - 'a']++;
        }
        int min = letters['b' - 'a'];
        min = Math.min(min, letters['a' - 'a']);
        min = Math.min(min, letters['l' - 'a'] / 2);
        min = Math.min(min, letters['o' - 'a'] / 2);
        min = Math.min(min, letters['n' - 'a']);
        return min;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string text
    Space Complexity: O(1)
*/
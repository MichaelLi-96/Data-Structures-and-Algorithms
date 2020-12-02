//https://leetcode.com/problems/longest-palindrome/

class Solution {
    public int longestPalindrome(String s) {
        // 128 ASCII characters
        int[] letters = new int[128];
        for(Character ch : s.toCharArray()) {
            letters[ch]++;
        }
        int mid = 0;
        int count = 0;
        for(int counts : letters) {
            if(counts % 2 == 1) {
                mid = 1;
                count += counts - 1;
            }
            else {
                count += counts;
            }
        }
        return count + mid;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input string S
	Space Complexity: O(1) since the letters array is constant despite different input strings
*/
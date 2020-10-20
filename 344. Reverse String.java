//https://leetcode.com/problems/reverse-string/

class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}

/*
	Time Complexity: O(n/2) -> O(n) where n is the length of the char[] s
	Space Complexity: O(1)
*/

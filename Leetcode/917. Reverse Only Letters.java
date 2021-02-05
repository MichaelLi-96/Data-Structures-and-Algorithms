//https://leetcode.com/problems/reverse-only-letters/

class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder str = new StringBuilder(S);
        int start = 0;
        int end = S.length() - 1;
        while(start < end) {
            if(!Character.isAlphabetic(S.charAt(start))) {
                start++;
            }
            else if(!Character.isAlphabetic(S.charAt(end))) {
                end--;
            }
            else {
                String temp = S.substring(start, start + 1);
                str.replace(start, start + 1, S.substring(end, end+1));
                str.replace(end, end + 1, temp);
                start++;
                end--;
            }
        }
        return str.toString();
    }
}

/*
	Time Complexity: O(n) where n is the length of the input String S
	Space Complexity: O(n) where n is the length of the input String S
*/
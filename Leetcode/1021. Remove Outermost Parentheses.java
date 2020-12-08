//https://leetcode.com/problems/remove-outermost-parentheses/

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder newStr = new StringBuilder();
        int offset = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            Character paren = S.charAt(i);
            if(paren == '(') {
                offset++;
            }
            else {
                offset--;
            }
            if(offset == 0) {
                newStr.append(S.substring(start + 1, i));
                start = i + 1;
            }
        }
        return newStr.toString();
    }
}


/*
    Time Complexity: O(n) where n is the length of the input string S
    Space Complexity: O(n) where n is the length of the input string S
*/
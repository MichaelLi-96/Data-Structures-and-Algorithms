//https://leetcode.com/problems/reformat-the-string/

class Solution {
    public String reformat(String s) {
        Stack<Character> letters = new Stack<>();
        Stack<Character> digits = new Stack<>();
        for(Character ch : s.toCharArray()) {
            if(Character.isLetter(ch)) {
                letters.push(ch);
            }
            else {
                digits.push(ch);
            }
        }
        
        if(Math.abs(letters.size() - digits.size()) >= 2) {
            return "";
        }
        
        boolean doDigit = digits.size() > letters.size();
        StringBuilder str = new StringBuilder();
        
        while(letters.size() != 0 || digits.size() != 0) {
            if(doDigit) {
                str.append(digits.pop());
            }
            else {
                str.append(letters.pop());
            }
            doDigit = !doDigit;
        }
        
        return str.toString();
    }
}

/*
    Time Complexity: O(2n) -> O(n) where n is the length of input string s 
    Space Complexity: O(2n) -> O(n) where n is the length of input string s 
*/ 
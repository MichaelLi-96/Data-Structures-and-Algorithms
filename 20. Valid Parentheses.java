//https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(ch);
            }
            else {
                Character top = stack.peek();
                if(ch == ')' && top == '(' || ch == ']' && top == '[' || ch == '}' && top == '{') {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }
}

/*
	Time Complexity: O(n) where n is the length of the string s
	Space Complexity: O(n) where n is the length of the string s
*/
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == '(') {
                stack.push(i);
            }
            else if(ch == ')') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                }
                else {
                    stack.push(i);
                }
            }
        }
        
        StringBuilder str = new StringBuilder(s);
        while(!stack.isEmpty()) {
            str.deleteCharAt(stack.pop());
        }
        return str.toString();
    }
}

/*
	Time Complexity: O(n) where n is the length of the input string s
	Space Complexity: O(n) where n is the length of the input string s
*/
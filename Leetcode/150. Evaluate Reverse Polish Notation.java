//https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            }
            else if(token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if(token.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string array tokens
    Space Complexity: O(n) where n is the length of the input string array tokens
*/

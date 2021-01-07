//https://leetcode.com/problems/score-of-parentheses/

class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(Character ch : S.toCharArray()) {
            if(ch == '(') {
                stack.push(0);
            }
            else {
                int prev1 = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2 + Math.max(2 * prev1, 1));
            }
        }
        return stack.pop();
    }
}


/*
    Time Complexity: O(n) where n is the length of the input string S
    Space Complexity: O(n) where n is the length of the input string S
*/

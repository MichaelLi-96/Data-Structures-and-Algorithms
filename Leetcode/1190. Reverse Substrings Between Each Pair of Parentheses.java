//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch != ')') {
                stack.push(ch);
            }
            else {
                while(stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()) {
                    stack.add(queue.poll());
                }
            }
        }
        while(!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }
}

/*
    Time Complexity: O(n^2) where n is the length of the input string s
    Space Complexity: O(n) where n is the length of the input string s
*/
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

class Solution {
    public int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;
        for(char ch : S.toCharArray()) {
            if(ch == '(') {
                left++;
            }
            else if(left > 0) {
                left--;
            }
            else {
                right++;
            }
        }
        return left + right;
    }
}

/*
    Time Complexity: O(n) where n is the length of input string S
    Space Complexity: O(1)
*/

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            Character ch = S.charAt(i);
            if(ch == ')' && stack.size() != 0 && stack.peek() == '(') {
                stack.pop();
            }
            else {
                stack.push(ch);   
            }
        }
        int count = 0;
        while(stack.size() != 0 && stack.peek() == '(') {
            stack.pop();
            count++;
        }
        return stack.size() + count;
    }
}

/*
    Time Complexity: O(n) where n is the length of input string S
    Space Complexity: O(n) where n is the length of input string S
*/
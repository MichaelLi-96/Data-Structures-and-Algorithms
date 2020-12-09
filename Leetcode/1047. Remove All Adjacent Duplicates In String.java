//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : S.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }
}

/*
    Time Complexity: O(2n) -> O(n) where n is the length of the input string S
    Space Complexity: O(n) where n is the length of the input string S
*/

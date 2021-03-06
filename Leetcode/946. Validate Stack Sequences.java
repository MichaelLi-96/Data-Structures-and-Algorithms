//https://leetcode.com/problems/validate-stack-sequences/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIdx = 0;
        for(int val : pushed) {
            stack.push(val);
            while(!stack.isEmpty() && stack.peek() == popped[poppedIdx]) {
                stack.pop();
                poppedIdx++;
            }
        }
        return stack.isEmpty();
    }
}

/*
    Time Complexity: O(2n) -> O(n) where n is the length of the input array pushed 
    Space Complexity: O(n) where n is the length of the input array pushed 
*/
//https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[T.length];
        for(int i = T.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.push(i);
                output[i] = 0;
            }
            else {
                while(!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    output[i] = 0;
                }
                else {
                    output[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }
        return output;
    }
}
/*
	Time Complexity: O(2n) -> O(n) where n is the length of the input int array T because each element is proccessed at most twice with pop and push
	Space Complexity: O(n) where n is the length of the input int array T 
*/
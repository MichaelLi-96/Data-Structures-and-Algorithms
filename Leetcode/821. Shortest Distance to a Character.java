//https://leetcode.com/problems/shortest-distance-to-a-character/

class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] output = new int[S.length()];
        Arrays.fill(output, Integer.MAX_VALUE);
        
        int charIndex = -1;
        for(int i = 0; i < output.length; i++) {
            if(S.charAt(i) == C) {
                charIndex = i;
            }
            if(charIndex != -1) {
                output[i] = i - charIndex;
            }
            
        }
        charIndex = -1;
        for(int i = output.length - 1; i >= 0; i--) {
            if(S.charAt(i) == C) {
                charIndex = i;
            }
            if(charIndex != -1) {
                output[i] = Math.min(output[i], charIndex - i);
            }
        }
        return output;
    }
}

// max max max 0 1 0 0 1 2 3 4 0
// 3 2 1 0 1 0 0 4 3 2 1 0 

/*
    Time Complexity: O(2n) -> O(n) where n is the length of the input String S
    Space Complexity: O(n) where n is the length of the input String S
*/

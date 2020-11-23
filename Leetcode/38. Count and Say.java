//https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        return helper(n, new StringBuilder("1"));
    }
    
    public String helper(int n, StringBuilder currentSeq) {
        if(n == 1) {
            return currentSeq.toString();
        }
        
        StringBuilder newSeq = new StringBuilder();
        int charCount = 0;
        Character currentChar = currentSeq.charAt(0);
        for(int i = 0; i < currentSeq.length(); i++) {
            if(currentSeq.charAt(i) == currentChar) {
                charCount++;
            }
            else {
                newSeq.append(charCount);
                newSeq.append(currentChar);
                charCount = 1;
                currentChar = currentSeq.charAt(i);
            }
        }    
        newSeq.append(charCount);
        newSeq.append(currentChar);
        return helper(n - 1, newSeq);
    }
}

/*
	Time Complexity: O(n * m) where n is the input int num and m is the length of the longest sequence string
	Space Complexity: O(1) auxiliary space, O(n) stack space from recursion
*/
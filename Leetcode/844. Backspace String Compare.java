//https://leetcode.com/problems/backspace-string-compare/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(Character ch : S.toCharArray()) {
            if(ch == '#') {
                if(!stackS.isEmpty()) {
                    stackS.pop();
                }
            }
            else {
                stackS.push(ch);
            }
        }
        for(Character ch : T.toCharArray()) {
            if(ch == '#') {
                if(!stackT.isEmpty()) {
                    stackT.pop();
                }
            }
            else {
                stackT.push(ch);
            }
        }
        
        while(!stackS.isEmpty() && !stackT.isEmpty()) {
            if(stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        if(stackS.size() > 0 || stackT.size() > 0) {
            return false;
        }
        return true;
    }
}

/*
	Time Complexity: O(n + m) where n is the length of the input String S and m is the length of the input String T
	Space Complexity: O(n + m) where n is the length of the input String S and m is the length of the input String T
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sPointer = S.length() - 1;
        int tPointer = T.length() - 1;
        int sBackspaces = 0;
        int tBackspaces = 0;
        while(sPointer >= 0 || tPointer >= 0) {
            if(sPointer >= 0 && S.charAt(sPointer) == '#') {
                sBackspaces++;
                sPointer--;
            }
            else if(tPointer >= 0 && T.charAt(tPointer) == '#') {
                tBackspaces++;
                tPointer--;
            }
            else {
                if(sBackspaces > 0) {
                    sPointer--;
                    sBackspaces--;
                }
                else if(tBackspaces > 0) {
                    tPointer--;
                    tBackspaces--;
                }
                else {
                    if((sPointer >= 0 && tPointer < 0) || (sPointer < 0 && tPointer >= 0) || (sPointer >= 0 && tPointer >= 0 && S.charAt(sPointer) != T.charAt(tPointer))) {
                        return false;
                    }
                    sPointer--;
                    tPointer--;
                }
            }
        }
        return true;
    }
}

/*
    Time Complexity: O(n + m) where n is the length of the input String S and m is the length of the input String T
    Space Complexity: O(1)
*/
//https://leetcode.com/problems/consecutive-characters/

class Solution {
    public int maxPower(String s) {
        int curLetter = s.charAt(0);
        int maxPower = 1;
        int curPower = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == curLetter) {
                curPower++;
            }
            else {
                maxPower = Math.max(maxPower, curPower);
                curPower = 1;
                curLetter = s.charAt(i);
            }
        }
        maxPower = Math.max(maxPower, curPower);
        return maxPower;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input String s 
    Space Complexity: O(1)
*/
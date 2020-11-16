//https://leetcode.com/problems/is-subsequence/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        int sPointer = 0;
        for(int i = 0; i < t.length(); i++) {
            if(sPointer < s.length() && t.charAt(i) == s.charAt(sPointer)) {
                sPointer++;
            }
        }
        return sPointer == s.length();
    }
}
/*
    Time Complexity: O(n) where n is the length of input string t
    Space Complexity: O(1)
*/
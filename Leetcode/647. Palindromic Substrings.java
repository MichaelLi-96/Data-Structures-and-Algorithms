//https://leetcode.com/problems/palindromic-substrings/

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }
    
    public int expandFromCenter(String s, int index1, int index2) {
        int count = 0;
        while(index1 >= 0 && index2 < s.length() && s.charAt(index1) == s.charAt(index2)) {
            index1--;
            index2++;
            count++;
        }
        return count;
    }
}


/*
    Time Complexity: O(n^2) where n is the length of the input string s
    Space Complexity: O(1)
*/
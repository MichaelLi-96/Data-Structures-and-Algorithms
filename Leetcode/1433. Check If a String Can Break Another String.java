//https://leetcode.com/problems/check-if-a-string-can-break-another-string/

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] s1Letters = new int[26];
        int[] s2Letters = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Letters[s1.charAt(i) - 'a']++;
            s2Letters[s2.charAt(i) - 'a']++;
        }
        
        int s1Count = 0;
        int s2Count = 0;
        boolean s1LexSmaller = false;
        boolean s2LexSmaller = false;
        for(int i = 0; i < 26; i++) {
            s1Count += s1Letters[i];
            s2Count += s2Letters[i];
            if(s1Count > s2Count) {
                if(s2LexSmaller) {
                    return false;
                }
                s1LexSmaller = true;
            }
            else if(s2Count > s1Count) {
                if(s1LexSmaller) {
                    return false;
                }
                s2LexSmaller = true;
            }
        }
        
        return true;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string s1
    Space Complexity: O(1) because we are making an array of length 26 everytime despite differing size inputs 
*/
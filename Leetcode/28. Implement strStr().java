//https://leetcode.com/problems/implement-strstr/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if(j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

/*
    Time Complexity: O(n * m) where n is the length of the input string haystack and m is the length of the input string needle 
    Space Complexity: O(1)
*/
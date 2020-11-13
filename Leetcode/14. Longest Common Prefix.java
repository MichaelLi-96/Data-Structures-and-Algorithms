//https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String lcp = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String word = strs[i];
            int j = 0;
            while(j < lcp.length() && j < word.length() && lcp.charAt(j) == word.charAt(j)) {
                j++;
            }
            lcp = lcp.substring(0, j);
        }
        return lcp;
    }
}

/*
	Time Complexity: O(n * m) where n is the length of the input strs array and m is the length of the longest string (possible lcp) in the array 
	Space Complexity: O(1) 
*/
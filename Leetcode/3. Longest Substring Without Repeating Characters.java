//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int longestLength = 0;
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(!set.contains(ch)) {
                set.add(ch);
            }
            else {
                longestLength = Math.max(longestLength, i - left);
                while(s.charAt(left) != ch) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
        }
        longestLength = Math.max(longestLength, s.length() - left);
        return longestLength;
    }
}

/*
	Time Complexity: O(2n) -> O(n) where n is the length of the input string s
	Space Complexity: O(n) where n is the length of the input string s
*/
//https://leetcode.com/problems/largest-substring-between-two-equal-characters/

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longestLength = -1;
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, i);
            }
            else {
                int prevIndex = map.get(ch);
                int substringLength = i - prevIndex - 1;
                longestLength = Math.max(substringLength, longestLength);
            }
        }
        return longestLength;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input String s
    Space Complexity: O(n) where n is the length of the input String s
*/

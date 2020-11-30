//https://leetcode.com/problems/isomorphic-strings/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            int sIndex = sMap.getOrDefault(s.charAt(i), -1);
            int tIndex = tMap.getOrDefault(t.charAt(i), -1);
            
            if(sIndex != tIndex) {
                return false;
            }
            
            sMap.put(s.charAt(i), i);
            tMap.put(t.charAt(i), i);
        }
        
        return true;
    }
}


/*
    Time Complexity: O(n) where n is the length of input string s
    Space Complexity: O(2n) -> O(n) where n is the length of input string s
*/
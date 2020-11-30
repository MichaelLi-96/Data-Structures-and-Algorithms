//https://leetcode.com/problems/word-pattern/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            if(map.containsKey(ch)) {
                if(!map.get(ch).equals(words[i])) {
                    return false;
                }
            }
            else {
                if(usedWords.contains(words[i])) {
                    return false;
                }
                map.put(ch, words[i]);
                usedWords.add(words[i]);            
            }
        }
        return true;
    }
}

/*
    Time Complexity: O(n) where n is the length of input string pattern
    Space Complexity: O(n + 2m) -> O(n + m) where n is the length of input string pattern and m is the length of input string s
*/
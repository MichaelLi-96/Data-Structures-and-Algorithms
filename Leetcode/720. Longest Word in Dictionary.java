//https://leetcode.com/problems/longest-word-in-dictionary/

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        Set<String> seen = new HashSet<>();
        seen.add("");
        int longestIdx = 0;
        for(int i = 0; i < words.length; i++) {
            String longestWord = words[longestIdx];
            String currentWord = words[i];
            if(seen.contains(currentWord.substring(0, currentWord.length() -  1))) {
                if(words[longestIdx].length() < currentWord.length()) {
                    longestIdx = i;
                }
                seen.add(words[i]);
            }
            
        }
        return words[longestIdx];
    }
}

/*
    Time Complexity: O(nlog(n) + n) where n is the length of the input String array words
    Space Complexity: O(n) where n is the length of the input String array words
*/
//https://leetcode.com/problems/print-words-vertically/

class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLength = 0;
        for(String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        StringBuilder[] verticalWords = new StringBuilder[maxLength];
        for(int i = 0; i < maxLength; i++) {
            verticalWords[i] = new StringBuilder();
        }
        for(int i = 0; i < maxLength; i++) {
            for(String word : words) {
                if(i < word.length()) {
                    verticalWords[i].append(word.charAt(i));
                }
                else {
                    verticalWords[i].append(" ");
                }
            }
        }
        
        List<String> list = new ArrayList<>();
        for(StringBuilder str : verticalWords) {
            list.add(str.toString().stripTrailing());
        }
        return list;
    }
}

/*
	Time Complexity: O(n * m) where n is the length of the longest word and m is the number of words in the input string s
	Space Complexity: O(n) where n is the length of the longest word in the input string s
*/
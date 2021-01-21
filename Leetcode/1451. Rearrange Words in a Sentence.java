//https://leetcode.com/problems/rearrange-words-in-a-sentence/

class Solution {
    public String arrangeWords(String text) {
        String[] allWords = text.split(" ");
        Map<Integer, Queue<String>> wordLengths = new HashMap<>();
        for(String word : allWords) {
            int length = word.length();
            if(!wordLengths.containsKey(length)) {
                Queue<String> words = new LinkedList<String>();
                words.add(word.toLowerCase());
                wordLengths.put(length, words);
            }
            else {
                wordLengths.get(length).add(word);
            }
        }
        StringBuilder output = new StringBuilder();
        for(int i = 1; i < 100000; i++) {
            if(wordLengths.containsKey(i)) {
                Queue<String> words = wordLengths.get(i);
                while(!words.isEmpty()) {
                    output.append(words.poll());
                    output.append(" ");
                }
            }
        }
        output.deleteCharAt(output.length() - 1);
        output.replace(0, 1, output.substring(0, 1).toUpperCase());
        return output.toString();
    }
}

/*
    Time Complexity: O(n) where n is the number of words contained in the input String text
    Space Complexity: O(n) where n is the number of words contained in the input String text
*/
//https://leetcode.com/problems/uncommon-words-from-two-sentences/

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> freq = new HashMap();
        for (String word : A.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        for (String word : B.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> uncommonWords = new ArrayList();
        for (String word: freq.keySet()) {
            if (freq.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
            

        return uncommonWords.toArray(new String[uncommonWords.size()]);
    }
}

/*
    Time Complexity: O(n + m) where n is the number of words in input string A and m is the number of words in input string B
    Space Complexity: O(n + m) where n is the number of words in input string A and m is the number of words in input string B
*/
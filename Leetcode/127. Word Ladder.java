//https://leetcode.com/problems/word-ladder/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int transformationCount = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] letters = word.toCharArray();
                for(int j = 0; j < letters.length; j++) {
                    char temp = letters[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        letters[j] = ch;
                        String nextWord = new String(letters);
                        if (set.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return transformationCount + 1;
                            }
                            queue.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    letters[j] = temp;
                }
            }
            transformationCount++;
        }
        return 0;
    }
}

O(N * M * 26 * M) = O(M^2 * N)

/*
	Time Complexity: O(n * m * 26 * m) -> O(m^2 * n) where m is the length of the input string beginWord and n is the size of the input list wordList
	Space Complexity: O(2n) -> O(n) where n is the size of the input list wordList
*/
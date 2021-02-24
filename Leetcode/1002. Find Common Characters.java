//https://leetcode.com/problems/find-common-characters/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> commonCharacters = new ArrayList<>();
        int[] letters = new int[26];
        for(int i = 0; i < A[0].length(); i++) {
            letters[A[0].charAt(i) - 'a']++;
        }
        for(int i = 1; i < A.length; i++) {
            int[] wordLetters = new int[26];
            for(int j = 0; j < A[i].length(); j++) {
                wordLetters[A[i].charAt(j) - 'a']++;
            }
            
            for(int j = 0; j < 26; j++) {
                int letterCount1 = letters[j];
                int letterCount2 = wordLetters[j];
                letters[j] = Math.min(letterCount1, letterCount2);
            }
        }
        
        for(int j = 0; j < 26; j++) {
            while(letters[j] > 0) {
                String ch = Character.toString((char)(j + 'a'));
                commonCharacters.add(ch);
                letters[j]--;
            }
            
        }
        
        return commonCharacters;
    }
}

/*
    Time Complexity: O(n * m) where n is the length of the input String array A and m is the length of the longest word in A 
    Space Complexity: O(1) not counting output list, O(n) counting output list where n is the length of the longest word in A
*/
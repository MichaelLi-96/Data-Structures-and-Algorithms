//https://leetcode.com/problems/letter-case-permutation/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> permutations = new ArrayList<>();
        backtracking(0, new StringBuilder(), S, permutations);
        return permutations;
    }
    
    public void backtracking(int currentIndex, StringBuilder currentStr, String S, List<String> permutations) {
        if(currentStr.length() == S.length()) {
            permutations.add(currentStr.toString());
            return;
        }
        Character ch = S.charAt(currentIndex);
        if(Character.isDigit(ch)) {
            backtracking(currentIndex + 1, currentStr.append(ch), S, permutations);
        }
        else {
            backtracking(currentIndex + 1, currentStr.append(Character.toUpperCase(ch)), S, permutations);
            currentStr.setLength(currentStr.length() - 1);
            backtracking(currentIndex + 1, currentStr.append(Character.toLowerCase(ch)), S, permutations);
        }
        currentStr.setLength(currentStr.length() - 1);
    }
}

/*
    Time Complexity: O(2^n) where n is the length of the input string S
    Space Complexity: O(2^n) where n is the length of the input string S
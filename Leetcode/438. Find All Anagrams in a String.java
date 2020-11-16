//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        int[] letters = new int[26];
        for(int i = 0; i < p.length(); i++) {
            letters[p.charAt(i) - 'a']++;
        }
        int count = p.length();
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            if(letters[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            letters[s.charAt(right) - 'a']--;
            right++;
            if(count == 0) {
                indexes.add(left);
            }
            if(right - left == p.length()) {
                if(letters[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                letters[s.charAt(left) - 'a']++;
                left++;
            }
            
        }
        return indexes;
    }
}

/*
    Time Complexity: O(n + m) where n is the length of input string s and m is the length of input string p 
    Space Complexity: O(1) as length of letters array remains constant despite different inputs
*/
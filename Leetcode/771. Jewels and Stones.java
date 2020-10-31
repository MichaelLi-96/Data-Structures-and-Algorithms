//https://leetcode.com/problems/jewels-and-stones/

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}

/*
    Time Complexity: O(n + m) where n is the length the input string J and m is the length of the input string S
    Space Complexity: O(n) where n is the length of the input string J
*/
//https://leetcode.com/problems/count-binary-substrings/

class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> groups = new ArrayList<>();
        int currentCount = 0;
        int currentChar = s.charAt(0);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == currentChar) {
                currentCount++;
            }
            else {
                groups.add(currentCount);
                currentCount = 1;
                currentChar = s.charAt(i);
            }
        }
        groups.add(currentCount);
        
        int output = 0;
        for(int i = 0; i < groups.size() - 1; i++) {
            int n1 = groups.get(i);
            int n2 = groups.get(i + 1);
            output += Math.min(n1, n2);
        }
        return output;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string s 
    Space Complexity: O(n) where n is the length of the input string s 
/*
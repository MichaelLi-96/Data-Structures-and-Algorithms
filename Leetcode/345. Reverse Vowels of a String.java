//https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            Character ch1 = s.charAt(start);
            Character ch2 = s.charAt(end);
            if(isVowel(ch1) && isVowel(ch2)) {
                str.replace(start, start + 1, ch2.toString());
                str.replace(end, end + 1, ch1.toString());
                start++;
                end--;
            }
            else {
                if(isVowel(ch1)) {
                    end--;
                }
                else if(isVowel(ch2)) {
                    start++;
                }
                else {
                    start++;
                    end--;
                }
            }
        }
        return str.toString();
        
    }
    
    public boolean isVowel(Character ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ; 
    }
}

/*
    Time Complexity: O(n) where n is the length of input string s
    Space Complexity: O(n) where n is the length of input string s
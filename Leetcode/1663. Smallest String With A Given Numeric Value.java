//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            str.append("a");
        }
        k -= n;
        int idx = str.length() - 1;
        while(k > 0) {
            if(k - 25 > 0) {
                str.setCharAt(idx, 'z');
                k -= 25;
            }
            else {
                str.setCharAt(idx, (char)('a' + k));
                k -= k;
            }
            idx--;
        }
        return str.toString();
    }
}

/*
	Time Complexity: O(k) 
	Space Complexity: O(n)
*/
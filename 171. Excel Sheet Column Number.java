//https://leetcode.com/problems/excel-sheet-column-number/

class Solution {
    public int titleToNumber(String s) {
        int power = 0;
        int sum = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int value = s.charAt(i) - 'A' + 1;
            sum += Math.pow(26, power) * value;
            power++;
        }
        return sum;
    }
}

/*
	Time Complexity: O(n) where n is the length of the string
	Space Complexity: O(1)
*/
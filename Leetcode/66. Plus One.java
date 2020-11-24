//https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        digits[digits.length - 1]++;
        for(int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if(carry) {
                digit += 1;
                carry = false;
            }
            if(digit == 10) {
                carry = true;
                digit = 0;
            }
            digits[i] = digit;
        }
        if(carry) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input array digits 
	Space Complexity: O(n) where n is the length of the input array digits 
*/
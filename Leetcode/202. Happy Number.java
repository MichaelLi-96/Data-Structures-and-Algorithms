//https://leetcode.com/problems/happy-number/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while(!seenNumbers.contains(n)) {
            seenNumbers.add(n);
            int sum = 0;
            while(n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if(sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}

/*
	Time Complexity: O(n * m) where n is the number of seen numbers that exist to 1 or a cycle and m is the number of digits in the biggest seen numebr
	Space Complexity: O(n) where n is the number of seen numbers that exist to 1 or a cycle
*/

// Follow up: can also be done in O(1) space using floyd cycle detection algorithm


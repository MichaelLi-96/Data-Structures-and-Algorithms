//https://leetcode.com/problems/water-bottles/

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int usedBottles = numBottles;
        int remainingBottles = numBottles;
        while(remainingBottles >= numExchange) {
            int temp = remainingBottles;
            remainingBottles /= numExchange;
            usedBottles += remainingBottles;
            remainingBottles += temp % numExchange;
        }
        return usedBottles;
    }
}

/*
    Time Complexity: O(log(n)) where n is the input int numBottles
    Space Complexity: O(1)
*/
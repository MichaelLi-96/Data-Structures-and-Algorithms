//https://leetcode.com/problems/check-if-it-is-a-straight-line/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope =  (double)(coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);
        for(int i = 2; i < coordinates.length; i++) {
            double currentSlope = (double)(coordinates[i][1] - coordinates[0][1]) / (double)(coordinates[i][0] - coordinates[0][0]);
            if(currentSlope != slope) {
                return false;
            }
        }
        return true;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int matrix coordinates
    Space Complexity: O(1)
*/
//https://leetcode.com/problems/count-number-of-teams/

class Solution {
    public int numTeams(int[] rating) {
        if(rating.length < 3) {
            return 0;
        }
        int count = 0;
        for(int i = 1; i < rating.length - 1; i++) {
            int soldierRating = rating[i];
            
            int leftBigger = 0;
            int leftSmaller = 0;
            for(int j = 0; j < i; j++) {
                if(rating[j] < soldierRating) {
                    leftSmaller++;
                }
                if(rating[j] > soldierRating) {
                    leftBigger++;
                }
            }
            
            int rightBigger = 0;
            int rightSmaller = 0;
            for(int j = i + 1; j < rating.length; j++) {
                if(rating[j] < soldierRating) {
                    rightSmaller++;
                }
                if(rating[j] > soldierRating) {
                    rightBigger++;
                }
            }
         
            count += leftBigger * rightSmaller + leftSmaller * rightBigger;

        }
        return count;
    }
}

/*
    Time Complexity: O(n^2) where n is the length of the input array ratings
    Space Complexity: O(1)
*/
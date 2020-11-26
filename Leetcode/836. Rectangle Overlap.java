//https://leetcode.com/problems/rectangle-overlap/

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1TopSide = rec1[3];
        int rec1RightSide = rec1[2];
        int rec1BottomSide = rec1[1];
        int rec1LeftSide = rec1[0];
        
        int rec2TopSide = rec2[3];
        int rec2RightSide = rec2[2];
        int rec2BottomSide = rec2[1];
        int rec2LeftSide = rec2[0];
        
        // Test if rectangles are lines 
        if(rec1RightSide - rec1LeftSide == 0 || rec1TopSide - rec1BottomSide == 0 || rec2RightSide - rec2LeftSide == 0 || rec2TopSide - rec2BottomSide == 0) {
            return false;
        }

        return rec1RightSide > rec2LeftSide && rec1TopSide > rec2BottomSide && rec2TopSide > rec1BottomSide && rec2RightSide > rec1LeftSide;
    }
}


/*
    Time Complexity: O(1) 
    Space Complexity: O(1)
*/
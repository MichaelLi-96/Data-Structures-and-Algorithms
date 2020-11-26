//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        
        List<int[]> list = new ArrayList<>();
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] <= curEnd) {
                curEnd = Math.max(curEnd, interval[1]);
            }
            else {
                list.add(new int[]{curStart, curEnd});
                curStart = interval[0];
                curEnd = interval[1];
            }
        }
        list.add(new int[]{curStart, curEnd});
        return listToMatrix(list);
    }
    
    public int[][] listToMatrix(List<int[]> list) {
        int[][] matrix = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            int[] row = list.get(i);
            matrix[i][0] = row[0];
            matrix[i][1] = row[1];
        }
        return matrix;
    }
}

/*
    Time Complexity: O(nlog(n) + O(n)) where n is the length of the input matrix intervals
    Space Complexity: O(n) where n is the length of the input matrix intervals
*/ 
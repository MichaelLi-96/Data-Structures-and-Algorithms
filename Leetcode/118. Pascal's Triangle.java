//https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnedList = new ArrayList<>();
        if(numRows == 0) {
            return returnedList;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        returnedList.add(firstRow);

        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j < i; j++) {
                List<Integer> prevRow = returnedList.get(returnedList.size() - 1);
                row.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            row.add(1);
            returnedList.add(row);
        }
        return returnedList;
    }
}

/*
	Time Complexity: O(n^2) where n is the input integer numRows
	Space Complexity: O(n^2) where n is the input integer numRows
*/
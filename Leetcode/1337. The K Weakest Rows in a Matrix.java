//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> soldierCountToRowIndex = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            int count = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    count++;
                }
            }
            if(!soldierCountToRowIndex.containsKey(count)) {
                soldierCountToRowIndex.put(count, new ArrayList<Integer>());
            }
            soldierCountToRowIndex.get(count).add(i);
        }
        int[] ans = new int[k];
        int idx = 0;
        for(int i = 0; i <= mat[0].length; i++) {
            if(soldierCountToRowIndex.containsKey(i)) {
                for(Integer rowIdx : soldierCountToRowIndex.get(i)) {
                    if(idx < k) {
                        ans[idx] = rowIdx;
                        idx++;
                    }
                }
            }
        }
        return ans;
    }
}

/*
    Time Complexity: O(n * m + n) where n is the number of rows in the input matrix mat and m is the number of cols in the input matrix mat
    Space Complexity: O(n) where n is the length of the row in the input matrix mat 
*/
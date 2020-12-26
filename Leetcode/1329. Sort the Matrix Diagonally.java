//https://leetcode.com/problems/sort-the-matrix-diagonally/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                int key = i - j;
                if(!map.containsKey(key)) {
                    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                    minHeap.add(mat[i][j]);
                    map.put(key, minHeap);
                }
                else {
                    map.get(key).add(mat[i][j]);
                }
            }
        }
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    
    }
}


/*
    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the input matrix mat 
    Space Complexity: O(n) where n is the number of diagonals in the input matrix mat 
*/
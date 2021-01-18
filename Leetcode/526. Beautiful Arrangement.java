//https://leetcode.com/problems/beautiful-arrangement/

class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        findArrangements(n, 1, visited);
        return count;
    }
    
    public void findArrangements(int n, int currentIdx, boolean[] visited) {
        if(currentIdx > n) {
            count++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && (currentIdx % i == 0 || i % currentIdx == 0)) {
                visited[i] = true;
                findArrangements(n, currentIdx + 1, visited);
                visited[i] = false;
            }
        }
    }
}

/*
    Time Complexity: O(n) where n is the number of valid permutations
    Space Complexity: O(n) where n is the input n
*/
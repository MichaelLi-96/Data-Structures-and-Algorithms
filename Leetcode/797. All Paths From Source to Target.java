//https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        backtracking(0, graph, currentPath, paths);
        return paths;
        
    }
    
    public void backtracking(int currentNode, int[][] graph, List<Integer> currentPath, List<List<Integer>> paths) {
        if(graph[currentNode] == graph[graph.length - 1]) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        
        for(int i = 0; i < graph[currentNode].length; i++) {
            currentPath.add(graph[currentNode][i]);
            backtracking(graph[currentNode][i], graph, currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}


/*
    Time Complexity: O(n * 2^n) where n is the length of the input graph array (n for making a new copy of an arraylist for a worst case of 2^n paths)
    Space Complexity: O(n * 2^n) where n is the length of the input graph array (n for making a new copy of an arraylist for a worst case of 2^n paths)
*/
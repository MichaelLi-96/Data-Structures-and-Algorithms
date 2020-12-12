//https://leetcode.com/problems/combinations/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(n, k, 1, new ArrayList<>(), list);
        return list;
    }
    
    public void backtracking(int n, int k, int idx, List<Integer> currentList, List<List<Integer>> list) {
        if(currentList.size() == k) {
            list.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = idx; i <= n; i++) {
            currentList.add(i);
            backtracking(n, k, i + 1, currentList, list);
            currentList.remove(currentList.size() - 1);
        }
    }
}
/*
	Time Complexity: O(C(n,k)) where n and k are the supplied int inputs
	Space Complexity: (C(n,k)) where n and k are the supplied int inputs
    (Taken from: https://stackoverflow.com/questions/24643367/whats-time-complexity-of-this-algorithm-for-finding-all-combinations#:~:text=Also%2C%20you%20end%20up%20generating,O(n%20choose%20k)%20.&text=The%20complexity%20is%20O(C,%2C%20n%5E(n%2Dk)))%20.)
*/
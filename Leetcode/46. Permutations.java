//https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pool = new ArrayList<>();
        for(int num : nums) {
            pool.add(num);    
        }
        backtracking(new ArrayList<>(), pool, list, nums);
        return list;
    }
    
    public void backtracking(List<Integer> currentList, List<Integer> currentPool, List<List<Integer>> returnedList, int[] nums) {
        if(currentList.size() == nums.length) {
            returnedList.add(new ArrayList(currentList));
            return;
        }
        for(int i = 0; i < currentPool.size(); i++) {
            int num = currentPool.remove(0);
            currentList.add(num);
            backtracking(currentList, currentPool, returnedList, nums);
            currentList.remove(currentList.size() - 1);
            currentPool.add(num);
        }
    }
}

/*
    Time Complexity: O(n * n!) where n is the length of the input nums array (n for making a new copy of an arraylist for n! permutations)
    Space Complexity: O(n * n!) where n is the length of the input nums array (n for making a new copy of an arraylist for n! permutations)
*/
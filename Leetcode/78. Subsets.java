//https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(0, new ArrayList<>(), list, nums);
        return list;
    }
    
    public void backtracking(int index, List<Integer> currentList, List<List<Integer>> returnedList, int[] nums) {
        if(index == nums.length) {
            returnedList.add(new ArrayList<>(currentList));
            return;
        }
        returnedList.add(new ArrayList<>(currentList));
        for(int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            backtracking(i + 1, currentList, returnedList, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}

/*
	Time Complexity: O(m * 2^n) where m is the length of the longest copied array and 2^n is the total amount of subsets created where n is the length of the input nums array
	Space Complexity: O(m * 2^n) where m is the length of the longest copied array and 2^n is the total amount of subsets created where n is the length of the input nums array
*/
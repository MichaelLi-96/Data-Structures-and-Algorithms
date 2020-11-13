//https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnedList = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, 0, new ArrayList<>(), returnedList);
        return returnedList;
    }
    
    public void backtracking(int[] candidates, int currentSum, int target, int startingPoint, List<Integer> currentList, List<List<Integer>> returnedList) {
        if(currentSum > target) {
            return;
        }
        if(currentSum == target) {
            returnedList.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = startingPoint; i < candidates.length; i++) {
            int num = candidates[i];
            currentList.add(num);
            backtracking(candidates, currentSum + num, target, i, currentList, returnedList);
            currentList.remove(currentList.size() - 1);
        }
    }
}


/*
    Time Complexity: O(nlog(n) + k * 2^n) where n is the length of the input candidates array and k is the average length of each combination sum array
    Space Complexity: O(k * 2^n) where n is the length of the input candidates array and k is the average length of each combination sum array
*/
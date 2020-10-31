//https://leetcode.com/problems/number-of-good-pairs/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; 
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            count += map.get(nums[i]) - 1;
        }
        
        return count;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input nums array
    Space Complexity: O(n) where n is the length of the input nums array
*/
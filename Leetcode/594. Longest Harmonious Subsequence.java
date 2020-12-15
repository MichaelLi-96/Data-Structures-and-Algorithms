//https://leetcode.com/problems/longest-harmonious-subsequence/

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.containsKey(num + 1)) {
                longest = Math.max(longest, map.get(num) + map.get(num + 1));
            }
            if(map.containsKey(num - 1)) {
                longest = Math.max(longest, map.get(num) + map.get(num - 1));
            }
        }
        return longest;
    }
}
/*
    Time Complexity: O(n) where n is the length of the input array nums
    Space Complexity: O(n) where n is the length of the input array nums
*/
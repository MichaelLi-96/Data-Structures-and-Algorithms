//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnedArr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                returnedArr[0] = i;
                returnedArr[1] = map.get(nums[i]);
            }
            else {
                int compliment = target - nums[i];
                set.add(compliment);
                map.put(compliment, i);
            }
        }
        return returnedArr;
    }
}

/*
	Time Complexity: O(n) where n is the length of the nums array
	Space Complexity: O(2n) -> O(n) where n is the length of the nums array
*/
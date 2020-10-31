//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            int index = Math.abs(num) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                list.add(i);
            }
        }
        return list;
    }
}

/*
	Time Complexity: O(2n) -> O(n) where n is the length of the input nums array
	Space Complexity: O(1) assuming the returned list does not count as extra space
*/
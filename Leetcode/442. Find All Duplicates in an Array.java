//https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            int idx = Math.abs(num) - 1;
            if(nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
            else {
                list.add(Math.abs(num));
            }
        }
        return list;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input int array numss
	Space Complexity: O(1) not counting the output arraylist
*/
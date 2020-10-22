//https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
            }
            else {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }
}

/*
	Time Complexity: O(n) where n is the length of the nums array
	Space Complexity: O(n) where n is the length of the nums array
*/
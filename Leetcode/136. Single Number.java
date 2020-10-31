//https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, false);
            }
            else {
                map.put(num, true);
            }
        }
        
        for(int num : nums) {
            if(map.get(num) == false) {
                return num;
            }
        }
        return 0;
    }
}

/*
	Time Complexity: O(2n) -> O(n) where n is the length of the nums array
	Space Complexity: O(n) where n is the length of the nums array
*/
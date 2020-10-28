//https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
    
/*
	Time Complexity: O(n) where n is the length of the input nums array 
	Space Complexity: O(n) where n is the length of the input nums array 
*/
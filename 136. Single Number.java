//https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            if(!list.contains(num)) {
                list.add(num);
            }
            else {
                list.remove(new Integer(num));
            }
        }
        return list.get(0);
    }
}

/*
	Time Complexity: O(n) where n is the length of the nums array
	Space Complexity: O(n) where n is the length of the nums array
*/
//https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxNum = 0;
        int currentMax = 0;
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(freq.get(num) > currentMax) {
                maxNum = num;
                currentMax = freq.get(num);
            }
        }
        return maxNum;
    }
}

/*
	Time Complexity: O(n) where n is the length of the nums array
	Space Complexity: O(n - (n/2)) -> O(n) where n is the length of the nums array
*/
//https://leetcode.com/problems/find-lucky-integer-in-an-array/

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int luckyNum = -1;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(entry.getKey() == entry.getValue()) {
                luckyNum = Math.max(luckyNum, entry.getKey());
            }
        }
        return luckyNum;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array arr
    Space Complexity: O(n) where n is the length of the input array arr
*/

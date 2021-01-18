//https://leetcode.com/problems/sort-array-by-increasing-frequency/

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> flattenedFreq = new HashMap<>();
        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(!flattenedFreq.containsKey(val)) {
                PriorityQueue<Integer> numbersWithSameFreq = new PriorityQueue<>((x, y) -> y - x);
                numbersWithSameFreq.add(key);
                flattenedFreq.put(val, numbersWithSameFreq);
            }
            else {
                flattenedFreq.get(val).add(key);
            }
        }
        
        int idx = 0;
        for(int i = 1; i <= 100; i++) {
            if(flattenedFreq.containsKey(i)) {
                PriorityQueue<Integer> numbersWithSameFreq = flattenedFreq.get(i);
                while(!numbersWithSameFreq.isEmpty()) {
                    int currentVal = numbersWithSameFreq.poll();
                    for(int j = 0; j < i; j++) {
                        nums[idx] = currentVal;
                        idx++;   
                    }
                }
            }
        }
        
        return nums;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array nums
    Space Complexity: O(n) where n is the length of the input array nums
*/
//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> freq.get(x) - freq.get(y));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(entry.getKey());
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        for(int i = 0; i < k; i++) {
            arr[i] = minHeap.poll();
        }
        return arr;
    }
}

/*
	Time Complexity: O(nlog(k)) where n is the the number of unique elements in the freq map and k is the input k. Heap takes log(n) to add and delete
	Space Complexity: O(n + k) where n is the size of the freq map and k is the number of elements in the heap which is at most k
*/ 
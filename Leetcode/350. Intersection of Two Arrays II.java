//https://leetcode.com/problems/intersection-of-two-arrays-i

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums2) {
            if(freq.containsKey(num) && freq.get(num) > 0) {
                list.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

/*
	Time Complexity: O(2n + m) where n is the shorter of the 2 input arrays nums1 and nums2 and m is the longer of the 2
	Space Complexity: O(3n) -< O(n) where n is the length of the input array nums1
*/
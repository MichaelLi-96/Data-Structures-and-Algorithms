//https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x, y) -> freq.get(y) - freq.get(x));
        for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.add(entry.getKey());
        }
        StringBuilder str = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Character ch = maxHeap.poll();
            for(int i = 0; i < freq.get(ch); i++) {
                str.append(ch);    
            }
            
        }

        return str.toString();
    }
}

/*
    Time Complexity: O(n) where n is the length of the input string s
    Space Complexity: O(n) where n is the length of the input string s
*/